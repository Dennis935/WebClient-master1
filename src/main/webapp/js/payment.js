$(document).ready(function() {
    // Submit form on button click
    $('form').submit(function(event) {
        event.preventDefault();
        var firstName = $('#firstname').val();
        var lastName = $('#lastname').val();
        var creditCardNumber = $('#creditcard').val();

        var customerUrl = 'http://localhost:8080/AppServerWar/api/rest/customers?firstname=' + encodeURIComponent(firstName) + '&lastname=' + encodeURIComponent(lastName);

        $.ajax({
            url: customerUrl,
            method: 'GET',
            dataType: 'json',
            success: function(data) {
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
                            alert("Der Warenkorb ist leer.");
                        }
                    } else {
                        alert("Die eingegebene Kreditkartennummer ist nicht korrekt.");
                    }
                } else {
                    alert("Kunde nicht gefunden.");
                }
            },
            error: function(error) {
                alert("Fehler beim Abrufen der Kunden-ID");
                // Handhaben Sie den Fehler entsprechend
            }
        });
    });

    function performBooking(cartItems, customerId, index) {
        if (index >= cartItems.length) {
            // Alle Buchungen abgeschlossen
            alert("Alle Buchungen wurden erfolgreich durchgeführt.");
            localStorage.removeItem('cartItems'); // Warenkorb leeren
            window.location.href = "success.jsp";
            return;
        }

        var cartItem = cartItems[index];
        var eventId = cartItem.eventId;
        var categoryId = cartItem.category.id;
        var categoryName = cartItem.category.name;
        var seatNumbers = cartItem.seats.join(',');

        var bookingUrl = 'http://localhost:8080/AppServerWar/api/rest/bookticket?eventid=' + encodeURIComponent(eventId) +
            '&categoryid=' + encodeURIComponent(categoryId) + '&customerid=' + encodeURIComponent(customerId) +
            '&list=' + encodeURIComponent(seatNumbers);

        // Führen Sie die Buchung durch
        $.ajax({
            url: bookingUrl,
            method: 'GET',
            dataType: 'json',
            success: function(response) {
                alert("Buchung erfolgreich für Kategorie: " + categoryId);
                // Weiterleiten oder andere Aktionen nach der erfolgreichen Buchung

                // Rufen Sie die Buchung für die nächste Kategorie auf
                performBooking(cartItems, customerId, index + 1);
            },
            error: function(error) {
                alert("Fehler beim Buchen für Kategorie: " + categoryName);

                performBooking(cartItems, customerId, index + 1);
            }
        });
    }
});
