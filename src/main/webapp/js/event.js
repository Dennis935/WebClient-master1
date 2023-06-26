$(document).ready(function() {
    // Get the event ID from the query parameter
    const urlParams = new URLSearchParams(window.location.search);
    const eventId = urlParams.get('id');
    var loader = $('#loader');
    console.log(eventId);
    loader.show(); // Display the loader

    $.ajax({
        url: 'http://localhost:8080/AppServerWar/api/rest/detailedevent?id=' + eventId,
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            displayEventDetails(data);
            loader.hide(); // Hide the loader
        },
        error: function() {
            alert('Error');
            loader.hide(); // Hide the loader
        }
    });

    function displayEventDetails(event) {
        $('#eventTitle').html(event.eventName);
        $('#eventDescription').html(event.eventDesc);
        $('#eventDate').html('<p class="details">Date:</p> ' + event.date);
        $('#eventLocation').html('<p class="details">Location:</p> ' + event.location);
        $('#eventTime').html('<p class="details">Time:</p> ' + event.time + ' Uhr');
        var videoUrl = 'http://localhost:8082/video?path=' + event.eventName;
        var videoElement = '<iframe src="' + videoUrl + '"></iframe>';
        $('#videoContainer').html(videoElement);

        var seatInfo = '';
        event.categories.forEach(function (category) {
            var seatOptions = '';
            var takenSeats = category.takenSeatNumbers || [];
            seatInfo += '<p class="category" data-category-id="' + category.id + '">Category: ' + category.categoryName + '</p>';

            seatOptions += '<select class="seat-select" multiple>';
            for (var i = 1; i <= category.numberOfSeats; i++) {
                if (takenSeats.includes(i)) {
                    seatOptions += '<option value="' + i + '" disabled>' + i + ' (Taken)</option>';
                } else {
                    seatOptions += '<option value="' + i + '">' + i + '</option>';
                }
            }
            seatOptions += '</select>';

            seatInfo += '<div class="seat-options">' + seatOptions + '</div>';

            // Add change event listener for the select element in this category
            seatInfo += '<div class="selected-seats"></div>'; // Container for selected seats of this category
        });

        $('#eventSeats').html('<p class="seats-heading">Seats:</p>' + seatInfo);

        $('.seat-select').change(function () {
            var selectedSeats = [];
            $(this).find('option:selected').each(function () {
                selectedSeats.push($(this).val());
            });

            // Find the corresponding selected seats container based on the category
            var categoryContainer = $(this).closest('.seat-options').next('.selected-seats');
            categoryContainer.html('Selected Seats: ' + selectedSeats.join(', '));

            // Update the Cart button to enable/disable based on seat selection
            updateCartButton();
        });
    }

    // Update the Cart button to enable/disable based on seat selection
    function updateCartButton() {
        var isSeatSelected = false;
        $('.seat-select').each(function () {
            if ($(this).val().length > 0) {
                isSeatSelected = true;
                return false; // Exit the loop if a seat is selected
            }
        });

        var addToCartButton = $('.addToCart-button');
        addToCartButton.prop('disabled', !isSeatSelected);
    }

    $('.addToCart-button').click(function() {
        var selectedSeats = [];
        var selectedCategory = '';
        var selectedCategoryId= '';
        var selectedEventId = eventId; // Store the event ID

        $('select option:selected').each(function() {
            selectedSeats.push($(this).val());
            selectedCategory = $(this).closest('.seat-options').prev('.category').text().replace('Category: ', '');
            selectedCategoryId = $(this).closest('.seat-options').prev('.category').data('category-id');
        });

        var eventDetails = {
            title: $('#eventTitle').text(),
            description: $('#eventDescription').text(),
            date: $('#eventDate').text(),
            location: $('#eventLocation').text(),
            time: $('#eventTime').text(),
        };

        var cartItem = {
            event: eventDetails,
            eventId: selectedEventId,
            category: {
                id: selectedCategoryId,
                name: selectedCategory
            },
            seats: selectedSeats,
        };

        // Get existing cart items from Local Storage
        var cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];

        // Check if selected seats already exist in the cart for the same category
        var isCategoryAlreadyInCart = false;
        for (var i = 0; i < cartItems.length; i++) {
            var currentItem = cartItems[i];

            if (currentItem.category === selectedCategory) {
                currentItem.seats = currentItem.seats.concat(selectedSeats);
                isCategoryAlreadyInCart = true;
                break;
            }
        }

        if (!isCategoryAlreadyInCart) {
            cartItems.push(cartItem);
        }

        // Store updated cart items in Local Storage
        localStorage.setItem('cartItems', JSON.stringify(cartItems));

        alert('Event details and seats added to cart successfully!');
    });

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


    //Wishlist
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
        var customerID = '<%= session.getAttribute("username") %>'; // Obtain the customer ID from the logged-in customer

        var url = 'http://localhost:8083/wishlist/add?eventId=' + eventId + '&customerId=' + 'tello';
        //var url = 'http://localhost:8083/wishlist/add?eventId=32a5aa13-cc3c-40df-ab98-c85e590cdd66&customerId=Tello';


        fetch(url, { method: 'GET' })
            .then(response => {
                if (response.ok) {
                    console.log('Event added to wishlist');
                    // Add the event to the wishlist locally
                    var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems')) || [];
                    wishlistItems.push({ event: { id: eventId } });
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
