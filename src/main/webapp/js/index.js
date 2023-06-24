$(document).ready(function() {
    var loader = $('#loader');
    var eventDataContainer = $('#eventData');
    var paginationContainer = $('#paginationContainer');
    var eventsPerPage = 8;
    var currentPage = 1;
    var events = [];

    loader.show(); // Display the loader

    $.ajax({
        url: 'http://localhost:8080/AppServerWar/api/rest/events',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            events = data;
            updateFilterOptions(events); // Aktualisiere die Filteroptionen basierend auf den verfügbaren Genre-Werten
            displayEvents(events);
            displayPagination(events);
            loader.hide(); // Hide the loader
        },
        error: function() {
            eventDataContainer.html('Fehler beim Abrufen der Daten.');
            loader.hide(); // Hide the loader
        }
    });

    $('#filterForm').on('submit', function(e) {
        e.preventDefault();

        var selectedGenres = [];
        var selectedStartDate = $('input[name="startDate"]').val();
        var selectedEndDate = $('input[name="endDate"]').val();

        $('input[name="genre"]:checked').each(function() {
            selectedGenres.push($(this).val());
        });

        var filteredEvents = filterEvents(events, selectedGenres, selectedStartDate, selectedEndDate);
        displayEvents(filteredEvents);
        displayPagination(filteredEvents);
    });

    function updateFilterOptions(events) {
        var genres = new Set(); // Set zum Sammeln der Genre-Werte

        $.each(events, function(index, event) {
            if (event.genre) {
                genres.add(event.genre);
            }
        });

        var filterForm = $('#filterForm');
        filterForm.empty();

        // Erzeuge die Checkboxen basierend auf den Genre-Werten
        var genreContainer = $('<div class="genreContainer"></div>'); // Container für die Checkboxen
        genres.forEach(function(genre) {
            var checkbox = $('<label><input type="checkbox" name="genre" value="'+ genre + '" style="cursor: pointer; margin-right: 5px;"> ' + genre + '</label>');
            genreContainer.append(checkbox);
        });
        filterForm.append(genreContainer);

        // Füge die Eingabefelder für den Datum-Bereich hinzu
        var dateInput = $('<label>Startdatum: <input type="date" name="startDate" style="width: 150px; margin-right: 25px; margin-bottom: 10px"></label>');
        dateInput.append('Enddatum: <input type="date" name="endDate" style="width: 150px;"></label><br>');
        filterForm.append(dateInput);

        // Füge den Filter-Button wieder hinzu
        var filterButton = $('<button class="filterButton" type="submit">Filtern</button>');
        filterForm.append(filterButton);
    }

    function filterEvents(events, selectedGenres, selectedStartDate, selectedEndDate) {
        return events.filter(function(event) {
            var genreMatch = selectedGenres.length === 0 || selectedGenres.includes(event.genre);
            var startDateMatch = !selectedStartDate || event.eventDate >= selectedStartDate;
            var endDateMatch = !selectedEndDate || event.eventDate <= selectedEndDate;
            return genreMatch && startDateMatch && endDateMatch;
        });
    }

    function displayEvents(events) {
        var startIndex = (currentPage - 1) * eventsPerPage;
        var endIndex = startIndex + eventsPerPage;
        var displayedEvents = events.slice(startIndex, endIndex);
        var eventData = '';


        $.each(displayedEvents, function(index, event) {
            eventData += '<div class="event">';
            eventData += '<h3>' + event.eventName + '</h3>';
            eventData += '<p>Datum: ' + event.eventDate + '</p>';
            eventData += '<p>Genre: ' + event.genre + '</p>';
            eventData += '<button class="openButton" data-event-id="' + event.id + '">Open</button>';
            eventData += '</div>';
        });
        eventDataContainer.html(eventData);

        // Klick-Event für den "Open" Button hinzufügen
        $('.openButton').click(function(e) {
            e.preventDefault(); // Verhindere das Standardverhalten des Buttons
            var eventId = $(this).data('event-id');
            var eventUrl = 'http://localhost:8080/WebClient-1.0-SNAPSHOT/event.jsp?id=' + eventId;
            window.location.href = eventUrl;
        });

    }

    function updatePaginationButtons() {
        $('.page').removeClass('active');
        $('.page[data-page="' + currentPage + '"]').addClass('active');
    }

    function displayPagination(events) {
        var totalPages = Math.ceil(events.length / eventsPerPage);
        var paginationHTML = '';

        for (var i = 1; i <= totalPages; i++) {
            paginationHTML += '<button class="page" data-page="' + i + '">' + i + '</button>';
        }

        paginationContainer.html(paginationHTML);

        $('.page').click(function(e) {
            e.preventDefault(); // Verhindere das Standardverhalten des Buttons
            var page = $(this).data('page');
            currentPage = page;
            displayEvents(events);
            updatePaginationButtons();
        });


        updatePaginationButtons();
    }

});


