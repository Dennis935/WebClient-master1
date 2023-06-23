package org.example.webclient.domain.modelClasses;



import org.example.webclient.entityClasses.EventEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class EventModel implements Serializable {
    private UUID id;
    private String startTime;
    private int duration;
    private EventSeriesModel eventSeries;
    private LocationModel location;
    private LocalDate eventDate;

    public EventModel() {

    }

    public EventModel(EventEntity entity) {
        setId(entity.getId());
        setStartTime(entity.getStarttime());
        setDuration(entity.getDuration());
        setEventSeries(new EventSeriesModel(entity.getEventSeries()));
        setLocation(new LocationModel(entity.getLocation()));
        setEventDate(entity.getEventDate());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public EventSeriesModel getEventSeries() {
        return eventSeries;
    }

    public void setEventSeries(EventSeriesModel eventSeries) {
        this.eventSeries = eventSeries;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
