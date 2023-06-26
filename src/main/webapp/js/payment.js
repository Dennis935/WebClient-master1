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
                customers = data;
                var customerId = customers[0].id; // Greife auf das erste Kundenobjekt im Array zu und extrahiere die ID

                var ticketNumbers = [];
                var cartItems = JSON.parse(localStorage.getItem('cartItems'));

                if (cartItems && cartItems.length > 0) {
                    for (var i = 0; i < cartItems.length; i++) {
                        var cartItem = cartItems[i];
                        var eventId = cartItem.eventId; // Event-ID aus dem cartItem extrahieren
                        var categoryId = cartItem.category.id; // Kategorie-ID aus dem cartItem extrahieren
                        var seatNumbers = cartItem.seats.join(','); // Sitznummern aus dem cartItem extrahieren
                        ticketNumbers.push(seatNumbers);
                    }

                    var bookingUrl = 'http://localhost:8080/AppServerWar/api/rest/bookticket?eventid=' + encodeURIComponent(eventId) +
                        '&categoryid=' + encodeURIComponent(categoryId) + '&customerid=' + encodeURIComponent(customerId) +
                        '&list=' + encodeURIComponent(ticketNumbers.join(','));

                    // Führen Sie die Buchung durch
                    $.ajax({
                        url: bookingUrl,
                        method: 'GET',
                        dataType: 'json',
                        success: function(response) {
                            alert("Erfolgreich");
                            // Weiterleiten oder andere Aktionen nach der erfolgreichen Buchung
                        },
                        error: function(error) {
                            alert("Fehler beim Buchen");
                            // Handhaben Sie den Fehler entsprechend
                        }
                    });
                } else {
                    alert("Der Warenkorb ist leer.");
                }
            },
            error: function(error) {
                alert("Fehler beim Abrufen der Kunden-ID");
                // Handhaben Sie den Fehler entsprechend
            }
        });
    });
});
