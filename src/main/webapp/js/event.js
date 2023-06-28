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
        $('#eventTitle').html('<strong>' + event.eventName + '</strong>');
        $('#eventDescription').html(event.eventDesc);
        $('#eventDate').html('<p class="details">Date:</p> ' + event.date);
        $('#eventLocation').html('<p class="details">Location:</p> ' + event.location);
        $('#eventTime').html('<p class="details">Time:</p> ' + event.time + ' Uhr');
        var videoUrl = 'http://localhost:8082/video?path=' + event.eventName;
        var videoElement = '<div class="video-container"><video src="' + videoUrl + '" width="540" height="360" controls></video></div>';
        $('#videoContainer').html(videoElement);


        var seatInfo = '';
        event.categories.forEach(function (category) {
            var seatOptions = '';
            var takenSeats = category.takenSeatNumbers || [];
            seatInfo += '<p class="category" data-category-id="' + category.id + '">Category: ' + category.categoryName + '</p>';

            seatOptions += '<div class="selected-seats-dropdown">';
            seatOptions += '<button class="dropdown-button">Select Seats</button>';
            seatOptions += '<div class="dropdown-content">';
            seatOptions += '<ul class="selected-seats-dropdown-list">';

            for (var i = 1; i <= category.numberOfSeats; i++) {
                if (takenSeats.includes(i)) {
                    seatOptions += '<li>';
                    seatOptions += '<input type="checkbox" value="' + i + '" disabled>';
                    seatOptions += '<label>' + i + ' (Taken)</label>';
                    seatOptions += '</li>';
                } else {
                    seatOptions += '<li>';
                    seatOptions += '<input type="checkbox" value="' + i + '">';
                    seatOptions += '<label>' + i + '</label>';
                    seatOptions += '</li>';
                }
            }
            seatOptions += '</ul>';
            seatOptions += '</div>';
            seatOptions += '</div>';

            seatInfo += '<div class="seat-options">' + seatOptions + '</div>';
            seatInfo += '<div class="selected-seats"></div>'; // Container for selected seats of this category
        });

        $('#eventSeats').html('<p class="seats-heading"></p>' + seatInfo);

        $('.selected-seats-dropdown .dropdown-button').click(function () {
            $(this).next('.dropdown-content').toggleClass('show');
        });

        $('.selected-seats-dropdown-list input[type="checkbox"]').change(function () {
            var selectedSeats = [];
            $(this).closest('.selected-seats-dropdown-list').find('input[type="checkbox"]:checked').each(function () {
                selectedSeats.push($(this).val());
            });

            // Find the corresponding selected seats container based on the category
            var categoryContainer = $(this).closest('.seat-options').next('.selected-seats');
            categoryContainer.html('<strong>Selected Seats:</strong> ' + selectedSeats.join(', ')).css('margin-bottom', '20px');

            // Update the Cart button to enable/disable based on seat selection
            updateCartButton();
        });
    }

    // Update the Cart button to enable/disable based on seat selection
    function updateCartButton() {
        var isSeatSelected = false;

        $('.selected-seats-dropdown-list input[type="checkbox"]').each(function () {
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
        var selectedCategories = [];
        var selectedEventId = eventId;

        $('.selected-seats-dropdown-list input[type="checkbox"]:checked').each(function() {
            var seat = $(this).val();
            var category = {
                name: $(this).closest('.seat-options').prev('.category').text().replace('Category: ', ''),
                id: $(this).closest('.seat-options').prev('.category').data('category-id')
            };

            var existingCategoryIndex = selectedCategories.findIndex(function(selectedCategory) {
                return selectedCategory.id === category.id;
            });

            if (existingCategoryIndex > -1) {
                // Category already exists in selectedCategories
                selectedCategories[existingCategoryIndex].seats.push(seat);
            } else {
                // New category
                category.seats = [seat];
                selectedCategories.push(category);
            }
        });

        var eventDetails = {
            title: $('#eventTitle').text(),
            description: $('#eventDescription').text(),
            date: $('#eventDate').text(),
            location: $('#eventLocation').text(),
            time: $('#eventTime').text(),
        };

        var cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];

        for (var i = 0; i < selectedCategories.length; i++) {
            var selectedCategory = selectedCategories[i];
            var isCategoryAlreadyInCart = false;

            for (var j = 0; j < cartItems.length; j++) {
                var currentItem = cartItems[j];

                if (currentItem.category.id === selectedCategory.id) {
                    var commonSeats = currentItem.seats.filter(function(seat) {
                        return selectedCategory.seats.includes(seat);
                    });

                    if (commonSeats.length > 0) {
                        Swal.fire({
                            icon: 'info',
                            title: 'Not Possible',
                            text: 'Selected seat(s) already exist in the cart for the same category.'
                        });                        return;
                    }

                    currentItem.seats = currentItem.seats.concat(selectedCategory.seats);
                    isCategoryAlreadyInCart = true;
                    break;
                }
            }

            if (!isCategoryAlreadyInCart) {
                var cartItem = {
                    event: eventDetails,
                    eventId: selectedEventId,
                    category: selectedCategory,
                    seats: selectedCategory.seats,
                };
                cartItems.push(cartItem);
            }
        }

        localStorage.setItem('cartItems', JSON.stringify(cartItems));
        Swal.fire({
            icon: 'success',
            title: 'Successfully added to shopping cart',
            confirmButtonColor: '#235da8',
            text: 'Your ticket seat(s) are in your shopping cart. Keep in mind that you tickets in your shopping cart are not reserved.'
        });
    });


    //Wishlist

    // Handle add to wishlist button click
    $(document).on('click', '.addToWishlist-button', function() {
        var customerID = $('#logoutButton').data('username');
        var url = 'http://localhost:8083/wishlist/add?eventId=' + eventId + '&customerId=' + customerID;

        function displayWishlistItems(event) {
            $('#eventTitle').html('<strong>' + event.eventName + '</strong>');
            $('#eventDescription').html(event.eventDesc);
            $('#eventDate').html('<p class="details">Date:</p> ' + event.date);
            $('#eventLocation').html('<p class="details">Location:</p> ' + event.location);
            $('#eventTime').html('<p class="details">Time:</p> ' + event.time + ' Uhr');
        }

        var eventDetails = {
            title: $('#eventTitle').text(),
            description: $('#eventDescription').text(),
            date: $('#eventDate').text(),
            location: $('#eventLocation').text(),
            time: $('#eventTime').text(),
        };

        fetch(url, { method: 'GET' })
            .then(response => {
                if (response.ok) {
                    console.log('Event added to wishlist');
                    var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems')) || [];
                    var wishlistItem = {
                        event: eventDetails,
                    };
                    wishlistItems.push(wishlistItem);
                    localStorage.setItem('wishlistItems', JSON.stringify(wishlistItems));
                    displayWishlistItems(eventDetails); // Pass eventDetails to the display function
                    location.reload(); // Refresh the page to reflect the updated wishlist
                } else {
                    console.error('Failed to add event to wishlist');
                }
            })
            .catch(error => {
                console.error('Error adding event to wishlist:', error);
            });
    });


    // Handle remove from wishlist button click
    $(document).on('click', '.removeWishlist-button', function() {
        var customerID = $('#logoutButton').data('username');
        // Make a request to remove the wishlist item
        var url = 'http://localhost:8083/wishlist/remove?eventId=' + eventId + '&customerId=' + customerID;

        fetch(url, { method: 'GET' })
            .then(response => {
                if (response.ok) {
                    console.log('Wishlist item removed');
                    // Remove the wishlist item locally
                    var wishlistItems = JSON.parse(localStorage.getItem('wishlistItems')) || [];
                    var updatedWishlistItems = wishlistItems.filter(item => item.event.id !== eventId);
                    localStorage.setItem('wishlistItems', JSON.stringify(updatedWishlistItems));
                    location.reload();
                } else {
                    console.error('Failed to remove wishlist item');
                }
            })
            .catch(error => {
                console.error('Error removing wishlist item:', error);
            });
    });

});

