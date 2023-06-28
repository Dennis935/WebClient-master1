$(document).ready(function() {
    const customerId = $('#logoutButton').data('username');
    console.log(customerId);
    fetch('http://localhost:8083/wishlist/display?customerId=' + customerId, { method: 'GET' })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Failed to retrieve wishlist');
            }
        })
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Error retrieving wishlist:', error);
        });


    var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems'));

    if (wishlistItems && wishlistItems.length > 0) {
        var wishlistItemsHtml = '';

        for (var i = 0; i < wishlistItems.length; i++) {
            var wishlistItem = wishlistItems[i];
            var event = wishlistItem.event;

            wishlistItemsHtml += '<div class="event">';
            wishlistItemsHtml += '<h3>' + event.title + '</h3>';
            wishlistItemsHtml += '<p>' + event.date + '</p>';
            wishlistItemsHtml += '<p>' + event.location + '</p>';
            wishlistItemsHtml += '<p>' + event.time + '</p>';
            wishlistItemsHtml += '<button class="remove-from-wishlist-button" data-index="' + i + '">Remove from Wishlist</button>';
            wishlistItemsHtml += '</div>';
        }

        $('#wishlistItems').html(wishlistItemsHtml);

        $('.event').click(function() {
            var index = $(this).index();
            var wishlistItem = wishlistItems[index];
            var eventId = wishlistItem.eventId;
            window.location.href = 'http://localhost:8080/WebClient-1.0-SNAPSHOT/event.jsp?id=' + eventId;
        });
    } else {
        $('#wishlistItems').html('<p>No items in the wishlist.</p>');
    }


    $(document).on('click', '.remove-from-wishlist-button', function() {
        var index = $(this).data('index');
        var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems'));

        if (wishlistItems && wishlistItems.length > index) {
            wishlistItems.splice(index, 1);
            localStorage.setItem('wishlistItems', JSON.stringify(wishlistItems));
            location.reload();
        }
    });

});

function redirectToPayment() {
    window.location.href = "payment.jsp";
}