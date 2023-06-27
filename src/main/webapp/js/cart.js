$(document).ready(function() {
    var cartItems = JSON.parse(localStorage.getItem('cartItems'));

    if (cartItems && cartItems.length > 0) {
        var cartItemsHtml = '';

        for (var i = 0; i < cartItems.length; i++) {
            var cartItem = cartItems[i];
            var event = cartItem.event;
            var category = cartItem.category.name;
            var seats = cartItem.seats;

            cartItemsHtml += '<div class="event">';
            cartItemsHtml += '<h3>' + event.title + '</h3>';
            cartItemsHtml += '<p>' + event.date + '</p>';
            cartItemsHtml += '<p>' + event.location + '</p>';
            cartItemsHtml += '<p>' + event.time + '</p>';
            cartItemsHtml += '<p><strong>Category:</strong> ' + category + '</p>';

            if (seats.length > 0) {
                cartItemsHtml += '<p><strong>Selected Seats:</strong></p>';
                cartItemsHtml += '<p>' + seats.join(', ') + '</p>';
            }


            cartItemsHtml += '<button class="deleteButton" data-index="' + i + '">Delete</button>';
            cartItemsHtml += '</div>';
        }

        $('#cartItems').html(cartItemsHtml);
    } else {
        $('#cartItems').html('<p>No items in the cart.</p>');
    }

    $(document).on('click', '.deleteButton', function() {
        var index = $(this).data('index');
        var cartItems = JSON.parse(localStorage.getItem('cartItems'));

        if (cartItems && cartItems.length > index) {
            cartItems.splice(index, 1);
            localStorage.setItem('cartItems', JSON.stringify(cartItems));
            location.reload(); // Refresh the page to reflect the updated cart
        }
    });


});

function redirectToPayment() {
    window.location.href = "payment.jsp";
}