package org.example.webclient.dtoClasses;


import org.example.webclient.domain.modelClasses.EventModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EventDto implements Serializable {
    private LocalDate eventDate;
    private String startTime;
    private EventSeriesDto eventSeries;
    private String location;

    private List<CategoryDto> categories;

    public EventDto() {

    }

    public EventDto(EventModel model, List<CategoryDto> categoryDtoList) {
        setEventDate(model.getEventDate());
        setStartTime(model.getStartTime());
        setLocation(model.getLocation().getLocationName() + ", " + model.getLocation().getCity());
        setEventSeries(new EventSeriesDto(model.getEventSeries()));
        setCategories(categoryDtoList);
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EventSeriesDto getEventSeries() {
        return eventSeries;
    }

    public void setEventSeries(EventSeriesDto eventSeries) {
        this.eventSeries = eventSeries;
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
