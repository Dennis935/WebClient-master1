package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.EventSeriesEntity;

import java.io.Serializable;
import java.util.UUID;

public class EventSeriesModel implements Serializable {
    private UUID id;
    private OrganizerModel organizer;
    private String seriesName;
    private String description;
    private String genre;
    private String artist;

    public EventSeriesModel() {

    }

    public EventSeriesModel(EventSeriesEntity entity) {
        setId(entity.getId());
        setSeriesName(entity.getSeriesName());
        setDescription(entity.getDescription());
        setGenre(entity.getGenre());
        setArtist(entity.getArtist());
        setOrganizer(new OrganizerModel(entity.getOrganizer()));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrganizerModel getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerModel organizer) {
        this.organizer = organizer;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
