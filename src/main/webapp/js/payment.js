$(document).ready(function () {
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
