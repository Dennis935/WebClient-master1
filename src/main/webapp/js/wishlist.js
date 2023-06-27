$(document).ready(function() {
    var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems'));

    if (wishlistItems && wishlistItems.length > 0) {
        var wishlistItemsHtml = '';

        for (var i = 0; i < wishlistItems.length; i++) {
            var wishlistItem = wishlistItems[i];
            var event = wishlistItem.event;

            wishlistItemsHtml += '<div class="event">';
            wishlistItemsHtml += '<h3>' + event.title + '</h3>';
            wishlistItemsHtml += '<p>' + event.description + '</p>';
            wishlistItemsHtml += '<p>' + event.date + '</p>';
            wishlistItemsHtml += '<p>' + event.location + '</p>';
            wishlistItemsHtml += '<p>' + event.time + '</p>';

            wishlistItemsHtml += '<button class="remove-from-wishlist-button" data-index="' + i + '">Remove from Wishlist</button>';
            wishlistItemsHtml += '</div>';
        }

        $('#wishlistItems').html(wishlistItemsHtml);
    } else {
        $('#wishlistItems').html('<p>No items in the wishlist.</p>');
    }

    // Handle remove from wishlist button click
    $(document).on('click', '.remove-from-wishlist-button', function() {
        var index = $(this).data('index');
        var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems'));

        if (wishlistItems && wishlistItems.length > index) {
            wishlistItems.splice(index, 1);
            localStorage.setItem('wishlistItems', JSON.stringify(wishlistItems));
            location.reload(); // Refresh the page to reflect the updated wishlist
        }
    });

    // Handle add to wishlist button click
    $(document).on('click', '.addToWishlist-button', function() {
        var eventID = $('#eventID').text(); // Obtain the event ID from the displayed element
        var customerID = '<%= session.getAttribute("username") %>'; // Obtain the customer ID from the logged-in customer

        var url = 'http://localhost:8083/wishlist?eventId=' + eventID + '&customerId=' + customerID;

        $.ajax({
            url: url,
            type: 'POST',
            beforeSend: function(xhr) {
                xhr.setRequestHeader('Access-Control-Allow-Origin', 'http://localhost:8080');
                xhr.setRequestHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
                xhr.setRequestHeader('Access-Control-Allow-Headers', 'Access-Control-Allow-Origin');
                xhr.setRequestHeader('Access-Control-Expose-Headers', 'def');
                xhr.setRequestHeader('Access-Control-Allow-Credentials', 'true');
                },
            success: function() {
                console.log('Event added to wishlist');
                // Add the event to the wishlist locally
                var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems')) || [];
                wishlistItems.push({ event: { id: eventID } });
                localStorage.setItem('wishlistItems', JSON.stringify(wishlistItems));
                location.reload(); // Refresh the page to reflect the updated wishlist
            },
            error: function() {
                console.error('Failed to add event to wishlist');
            }
        });
    });
});
