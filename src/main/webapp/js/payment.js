$(document).ready(function () {
    var cartItems = JSON.parse(localStorage.getItem('cartItems'));

    if (cartItems && cartItems.length > 0) {
        var cartItemsHtml = '';

        for (var i = 0; i < cartItems.length; i++) {
            var cartItem = cartItems[i];
            var event = cartItem.event;
            var category = cartItem.category.name;
            var seats = cartItem.seats;

            cartItemsHtml += '<div class="col-md-6">';
            cartItemsHtml += '<div class="card mb-3">';
            cartItemsHtml += '<div class="card-body">';
            cartItemsHtml += '<h5 class="card-title">' + event.title + '</h5>';
            cartItemsHtml += '<p class="card-text"><strong>Date:</strong> ' + event.date + '</p>';
            cartItemsHtml += '<p class="card-text"><strong>Location:</strong> ' + event.location + '</p>';
            cartItemsHtml += '<p class="card-text"><strong>Time:</strong> ' + event.time + '</p>';
            cartItemsHtml += '<p class="card-text"><strong>Category:</strong> ' + category + '</p>';

            if (seats.length > 0) {
                cartItemsHtml += '<p class="card-text"><strong>Selected Seats:</strong> ' + seats.join(', ') + '</p>';
            }

            cartItemsHtml += '</div>';
            cartItemsHtml += '</div>';
            cartItemsHtml += '</div>';
        }

        $('#cartItems').html(cartItemsHtml);
    } else {
        $('#cartItems').html('<p>No items to buy</p>');
    }


    $('form').submit(function (event) {
        event.preventDefault();
        var firstName = $('#firstname').val();
        var lastName = $('#lastname').val();
        var creditCardNumber = $('#creditcard').val();

        var customerUrl = 'http://localhost:8080/AppServerWar/api/rest/customers?firstname=' +
            encodeURIComponent(firstName) + '&lastname=' + encodeURIComponent(lastName);

        //Loader
        Swal.fire({
            icon: 'info',
            title: 'Buchung wird bearbeitet...',
            showConfirmButton: false,
            allowOutsideClick: false,
            willOpen: () => {
                Swal.showLoading();
            }
        });

        $.ajax({
            url: customerUrl,
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                var customers = data;
                if (customers.length > 0) {
                    var customer = customers[0];
                    var customerId = customer.id;
                    var storedCreditCardNumber = customer.creditCardNumber;

                    if (creditCardNumber === storedCreditCardNumber) {
                        var cartItems = JSON.parse(localStorage.getItem('cartItems'));

                        if (cartItems && cartItems.length > 0) {
                            performBooking(cartItems, customerId, 0);
                        } else {
                            Swal.fire({
                                icon: 'info',
                                title: 'Warenkorb ist leer',
                                text: 'Der Warenkorb ist leer.',
                                confirmButtonColor: '#235da8',
                                timer: 3000,
                                timerProgressBar: true
                            }).then(function () {
                                Swal.close(); // Close the Swal alert
                            });
                        }
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Falsche Kreditkartennummer',
                            text: 'Die eingegebene Kreditkartennummer ist nicht korrekt.',
                            confirmButtonColor: '#235da8',
                            timer: 3000,
                            timerProgressBar: true
                        }).then(function () {
                            Swal.close(); // Close the Swal alert
                        });
                    }
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Kunde nicht gefunden',
                        text: 'Kunde nicht gefunden.',
                        confirmButtonColor: '#235da8',
                        timer: 3000,
                        timerProgressBar: true
                    }).then(function () {
                        Swal.close(); // Close the Swal alert
                    });
                }
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Fehler beim Abrufen der Kunden-ID',
                    text: 'Beim Abrufen der Kunden-ID ist ein Fehler aufgetreten.',
                    confirmButtonColor: '#235da8',
                    timer: 3000,
                    timerProgressBar: true
                }).then(function () {
                    Swal.close(); // Close the Swal alert
                });
            }
        });
    });

    function performBooking(cartItems, customerId, index) {
        if (index >= cartItems.length) {
            Swal.fire({
                icon: 'success',
                title: 'Buchungen erfolgreich',
                text: 'Alle Buchungen wurden erfolgreich durchgeführt.',
                timer: 3000,
                timerProgressBar: true
            }).then(function () {
                localStorage.removeItem('cartItems');
                window.location.href = "success.jsp";
            });

            return;
        }

        var cartItem = cartItems[index];
        var eventId = cartItem.eventId;
        var categoryId = cartItem.category.id;
        var categoryName = cartItem.category.name;
        var seatNumbers = cartItem.seats.join(',');

        var bookingUrl = 'http://localhost:8080/AppServerWar/api/rest/bookticket?eventid=' +
            encodeURIComponent(eventId) + '&categoryid=' + encodeURIComponent(categoryId) +
            '&customerid=' + encodeURIComponent(customerId) + '&list=' + encodeURIComponent(seatNumbers);

        $.ajax({
            url: bookingUrl,
            method: 'GET',
            dataType: 'json',
            success: function (response) {
                Swal.fire({
                    icon: 'success',
                    title: 'Buchung erfolgreich',
                    text: 'Buchung erfolgreich für Kategorie: ' + categoryName,
                    timer: 3000,
                    timerProgressBar: true
                }).then(function () {
                    performBooking(cartItems, customerId, index + 1);
                });
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Fehler beim Buchen',
                    text: 'Fehler beim Buchen für Kategorie: ' + categoryName,
                    confirmButtonColor: '#235da8',
                    timer: 3000,
                    timerProgressBar: true
                }).then(function () {
                    performBooking(cartItems, customerId, index + 1);
                });
            },
            complete: function () {
                if (index >= cartItems.length - 1) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Buchungen erfolgreich',
                        text: 'Alle Buchungen wurden erfolgreich durchgeführt.',
                        confirmButtonColor: '#235da8',
                        timer: 3000,
                        timerProgressBar: true
                    }).then(function () {
                        localStorage.removeItem('cartItems');
                        window.location.href = "success.jsp";
                    });
                }
            }
        });
    }
});

