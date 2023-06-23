package org.example.webclient.entityClasses;

import jakarta.persistence.*;
import org.example.webclient.domain.modelClasses.EventSeriesModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "event_series")
public class EventSeriesEntity implements Serializable {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "series_name")
    private String seriesName;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "artist")
    private String artist;
    @ManyToOne
    @JoinColumn (name = "organizer_id")
    private OrganizerEntity organizer;

    public EventSeriesEntity() {

    }

    public EventSeriesEntity(EventSeriesModel model) {
        setId(model.getId());
        setOrganizer(new OrganizerEntity(model.getOrganizer()));
        setSeriesName(model.getSeriesName());
        setDescription(model.getDescription());
        setGenre(model.getGenre());
        setArtist(model.getArtist());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public OrganizerEntity getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerEntity organizer) {
        this.organizer = organizer;
    }
}
