package org.example.webclient.entityClasses;

import jakarta.persistence.*;
import org.example.webclient.domain.modelClasses.TicketModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ticket")
public class TicketEntity implements Serializable {
    @GeneratedValue()
    @Id
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @Basic
    @Column(name = "seat_number")
    private int seatNumber;
    @Basic
    @Column(name = "customer_id")
    private UUID customer;

    public TicketEntity() {

    }

    public TicketEntity(TicketModel model) {
        setId(model.getId());
        setEvent(new EventEntity(model.getEvent()));
        setCategory(new CategoryEntity(model.getCategory()));
        setSeatNumber(model.getSeatNumber());
        setCustomer(model.getCustomer());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
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
