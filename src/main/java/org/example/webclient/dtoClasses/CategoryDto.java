package org.example.webclient.dtoClasses;

import org.example.webclient.domain.modelClasses.CategoryModel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class CategoryDto implements Serializable {
    private UUID id;
    private String categoryName;
    private int price;
    private int numberOfSeats;
    private List<Integer> takenSeatNumbers;

    public CategoryDto() {

    }

    public CategoryDto(CategoryModel model, List<Integer> availability) {
        setId(model.getId());
        setCategoryName(model.getCategoryName());
        setPrice(model.getPrice());
        setNumberOfSeats(model.getNumberOfSeats());
        setTakenSeatNumbers(availability);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public List<Integer> getTakenSeatNumbers() {
        return takenSeatNumbers;
    }

    public void setTakenSeatNumbers(List<Integer> takenSeatNumbers) {
        this.takenSeatNumbers = takenSeatNumbers;
    }
}
