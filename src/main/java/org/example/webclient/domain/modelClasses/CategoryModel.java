package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.CategoryEntity;

import java.io.Serializable;
import java.util.UUID;

public class CategoryModel implements Serializable {
    private UUID id;
    private EventModel event;
    private String categoryName;
    private int price;
    private int numberOfSeats;

    public CategoryModel() {

    }

    public CategoryModel(CategoryEntity entity) {
        setId(entity.getId());
        setEvent(new EventModel(entity.getEvent()));
        setCategoryName(entity.getCategoryName());
        setPrice(entity.getPrice());
        setNumberOfSeats(entity.getNumberOfSeats());
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
