$(document).ready(function() {
    var cartItems = JSON.parse(localStorage.getItem('cartItems'));

    if (cartItems && cartItems.length > 0) {
        var cartItemsHtml = '';

        for (var i = 0; i < cartItems.length; i++) {
            var cartItem = cartItems[i];
            var event = cartItem.event;
            var seats = cartItem.seats;

            cartItemsHtml += '<div class="event">';
            cartItemsHtml += '<h3>' + event.title + '</h3>';
            cartItemsHtml += '<p>' + event.description + '</p>';
            cartItemsHtml += '<p>' + event.date + '</p>';
            cartItemsHtml += '<p>' + event.location + '</p>';
            cartItemsHtml += '<p>' + event.time + '</p>';

            if (seats.length > 0) {
                cartItemsHtml += '<p>Selected Seats:</p>';
                for (var j = 0; j < seats.length; j++) {
                    cartItemsHtml += '<p><strong>' + seats[j] + '</strong></p>';
                }
            }

            cartItemsHtml += '<button class="delete-button" data-index="' + i + '" style="background-color: crimson">Delete</button>';
            cartItemsHtml += '</div>';
        }

        $('#cartItems').html(cartItemsHtml);
    } else {
        $('#cartItems').html('<p>No items in the cart.</p>');
    }

    // Handle delete button click
    $(document).on('click', '.delete-button', function() {
        var index = $(this).data('index');
        var cartItems = JSON.parse(localStorage.getItem('cartItems'));

        if (cartItems && cartItems.length > index) {
            cartItems.splice(index, 1);
            localStorage.setItem('cartItems', JSON.stringify(cartItems));
            location.reload(); // Refresh the page to reflect the updated cart
        }
    });
});
