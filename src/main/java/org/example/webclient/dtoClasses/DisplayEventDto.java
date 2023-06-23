package org.example.webclient.dtoClasses;

import org.example.webclient.domain.modelClasses.EventModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class DisplayEventDto implements Serializable {
    private UUID id;
    private LocalDate eventDate;
    private String location;
    private String eventName;
    private String artist;
    private String availability;
    private String genre;

    public DisplayEventDto() {

    }

    public DisplayEventDto(EventModel model, boolean available) {
        setId(model.getId());
        setEventDate(model.getEventDate());
        setLocation(model.getLocation().getLocationName());
        setEventName(model.getEventSeries().getSeriesName());
        setArtist(model.getEventSeries().getArtist());
        setGenre(model.getEventSeries().getGenre());
        if (available) {
            setAvailability("available");
        } else {
            setAvailability("booked");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
