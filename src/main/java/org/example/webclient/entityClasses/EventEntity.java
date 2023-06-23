package org.example.webclient.entityClasses;

import jakarta.persistence.*;
import org.example.webclient.domain.modelClasses.EventModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "event")
public class EventEntity implements Serializable {
    @GeneratedValue()
    @Id
    @Column(name = "id")
    private UUID id;
    @Basic
    @Column(name = "starttime")
    private String starttime;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @ManyToOne
    @JoinColumn(name = "event_series_id")
    private EventSeriesEntity eventSeries;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;
    @Basic
    @Column(name = "event_date")
    private LocalDate eventDate;

    public EventEntity() {

    }

    public EventEntity(EventModel model) {
        setId(model.getId());
        setStarttime(model.getStartTime());
        setDuration(model.getDuration());
        setEventSeries(new EventSeriesEntity(model.getEventSeries()));
        setLocation(new LocationEntity(model.getLocation()));
        setEventDate(model.getEventDate());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public EventSeriesEntity getEventSeries() {
        return eventSeries;
    }

    public void setEventSeries(EventSeriesEntity eventSeries) {
        this.eventSeries = eventSeries;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

}
