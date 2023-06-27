$(document).ready(function() {
    var customerId = $('#logoutButton').data('username');
    $.ajax({
        url: 'http://localhost:8083/wishlist/display',
        type: 'GET',
        data: { customerId: customerId },
        success: function(response) {
            var wishlistItems = response;

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
        },
        error: function() {
            console.log('Error occurred while fetching wishlist items.');
        }
    });
});
