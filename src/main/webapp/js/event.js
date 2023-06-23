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
        $('#eventTitle').text('Title: ' + event.eventName);
        $('#eventDescription').text('Description: ' + event.eventDesc);
        $('#eventDate').text('Date: ' + event.date);
        $('#eventLocation').text('Location: ' + event.location);
        $('#eventTime').text('Time: ' + event.time + ' Uhr');

        var seatInfo = '';
        event.categories.forEach(function(category) {
            var seatOptions = '';
            var takenSeats = category.takenSeatNumbers || []; // Falls takenSeatNumbers nicht definiert ist, verwenden wir ein leeres Array
            seatInfo += 'Category: ' + category.categoryName + '<br>';

            seatOptions += '<select multiple>';
            for (var i = 1; i <= category.numberOfSeats; i++) {
                if (takenSeats.includes(i)) {
                    seatOptions += '<option value="' + i + '" disabled>' + i + ' (Taken)</option>';
                } else {
                    seatOptions += '<option value="' + i + '">' + i + '</option>';
                }
            }
            seatOptions += '</select>';

            seatInfo += seatOptions + '<br><br>';
        });

        $('#eventSeats').html('Seats:<br>' + seatInfo);

        $('select').change(function() {
            var selectedSeats = [];
            $(this).find('option:selected').each(function() {
                selectedSeats.push($(this).val());
            });
            $('#selectedSeats').text('Selected Seats: ' + selectedSeats.join(', '));
        });
    }

    // Event handler for AddToCart button
    $('.addToCart-button').click(function() {
        var selectedSeats = [];
        $('select option:selected').each(function() {
            selectedSeats.push($(this).val());
        });

        var eventDetails = {
            title: $('#eventTitle').text(),
            description: $('#eventDescription').text(),
            date: $('#eventDate').text(),
            location: $('#eventLocation').text(),
            time: $('#eventTime').text(),
            category: $('#eventCategory').text()
        };

        var cartItem = {
            event: eventDetails,
            seats: selectedSeats
        };

        // Get existing cart items from Local Storage
        var cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];

        // Add new cart item
        cartItems.push(cartItem);

        // Store updated cart items in Local Storage
        localStorage.setItem('cartItems', JSON.stringify(cartItems));

        alert('Event details and seats added to cart successfully!');
    });

});