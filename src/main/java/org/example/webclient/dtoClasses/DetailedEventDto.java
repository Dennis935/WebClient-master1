package org.example.webclient.dtoClasses;

import org.example.webclient.domain.modelClasses.EventModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class DetailedEventDto implements Serializable {
    private UUID id;
    private String eventName;
    private String eventDesc;
    private String artist;
    private LocalDate date;
    private String time;
    private String location;
    private List<CategoryDto> categories;

    public DetailedEventDto() {

    }

    public DetailedEventDto(EventModel model) {
        setId(model.getId());
        setEventName(model.getEventSeries().getSeriesName());
        setEventDesc(model.getEventSeries().getDescription());
        setArtist(model.getEventSeries().getArtist());
        setDate(model.getEventDate());
        setTime(model.getStartTime());
        setLocation(model.getLocation().getLocationName() + ", "
                + model.getLocation().getCity() + ", "
                + model.getLocation().getStreet() + " "
                + model.getLocation().getHouseNumber());

    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
}
