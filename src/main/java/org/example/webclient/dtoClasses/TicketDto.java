package org.example.webclient.dtoClasses;

import org.example.webclient.domain.modelClasses.TicketModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class TicketDto implements Serializable {
    private UUID id;
    private UUID eventId;
    private UUID categoryId;
    private int seatNumber;
    private UUID customerId;

    private LocalDate date;
    private String eventName;
    private String location;
    private String categoryName;
    private int price;

    public TicketDto() {
    }

    public TicketDto(TicketModel model) {
        setId(model.getId());
        setEventId(model.getEvent().getId());
        setCategoryId(model.getCategory().getId());
        setSeatNumber(model.getSeatNumber());
        setCustomerId(model.getCustomer());
        setDate(model.getEvent().getEventDate());
        setEventName(model.getEvent().getEventSeries().getSeriesName());
        setLocation(model.getEvent().getLocation().getLocationName() + ", " + model.getEvent().getLocation().getCity() + ", " + model.getEvent().getLocation().getStreet() + " " + model.getEvent().getLocation().getHouseNumber());
        setCategoryName(model.getCategory().getCategoryName());
        setPrice(model.getCategory().getPrice());
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
