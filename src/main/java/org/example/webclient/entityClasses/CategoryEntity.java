package org.example.webclient.entityClasses;

import jakarta.persistence.*;
import org.example.webclient.domain.modelClasses.CategoryModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {
    @GeneratedValue()
    @Id
    @Column(name = "id")
    private UUID id;
    @ManyToOne
    @JoinColumn (name = "event_id")
    private EventEntity event;
    @Basic
    @Column(name = "category_name")
    private String categoryName;
    @Basic
    @Column(name = "price")
    private int price;
    @Basic
    @Column(name = "number_of_seats")
    private int numberOfSeats;

    public CategoryEntity() {

    }

    public CategoryEntity(CategoryModel model) {
        setId(model.getId());
        setEvent(new EventEntity(model.getEvent()));
        setCategoryName(model.getCategoryName());
        setPrice(model.getPrice());
        setNumberOfSeats(model.getNumberOfSeats());
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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
