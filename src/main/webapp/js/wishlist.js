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

        // var url = 'http://localhost:8083/wishlist?eventId=' + eventID + '&customerId=' + customerID;
        var url = 'http://localhost:8083/wishlist/add?eventId=32a5aa13-cc3c-40df-ab98-c85e590cdd66&customerId=Tello';


        fetch(url, { method: 'GET' })
            .then(response => {
                if (response.ok) {
                    console.log('Event added to wishlist');
                    // Add the event to the wishlist locally
                    var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems')) || [];
                    wishlistItems.push({ event: { id: eventID } });
                    localStorage.setItem('wishlistItems', JSON.stringify(wishlistItems));
                    location.reload(); // Refresh the page to reflect the updated wishlist
                } else {
                    console.error('Failed to add event to wishlist');
                }
            })
            .catch(error => {
                console.error('Error adding event to wishlist:', error);
            });
    });
});