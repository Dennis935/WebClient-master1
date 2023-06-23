package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.TicketEntity;

import java.io.Serializable;
import java.util.UUID;

public class TicketModel implements Serializable {
    private UUID id;
    private EventModel event;
    private CategoryModel category;
    private int seatNumber;
    private UUID customer;

    public TicketModel() {

    }

    public TicketModel(TicketEntity entity) {
        setId(entity.getId());
        setEvent(new EventModel(entity.getEvent()));
        setCategory(new CategoryModel(entity.getCategory()));
        setSeatNumber(entity.getSeatNumber());
        setCustomer(entity.getCustomer());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EventModel getEvent() {
        return event;
    }

    public void setEvent(EventModel event) {
        this.event = event;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public UUID getCustomer() {
        return customer;
    }

    public void setCustomer(UUID customer) {
        this.customer = customer;
    }
}
