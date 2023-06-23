package org.example.webclient.dtoClasses;


import org.example.webclient.domain.modelClasses.EventSeriesModel;

import java.io.Serializable;

public class EventSeriesDto implements Serializable {
    private String eventName;
    private String artist;
    private String genre;
    private String description;

    public EventSeriesDto() {

    }

    public EventSeriesDto(EventSeriesModel model) {
        setEventName(model.getSeriesName());
        setArtist(model.getArtist());
        setGenre(model.getGenre());
        setDescription(model.getDescription());

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
