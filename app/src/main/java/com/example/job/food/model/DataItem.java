package com.example.job.food.model;

import java.util.UUID;

/**
 * Created by JOB on 8/26/2017.
 */

public class DataItem {

    private String itemId;
    private String itemName;
    private String category;
    private String description;
    private int sortPosition;
    private double price;
    private String image;

    public DataItem() {
    }

    public DataItem(String itemId, String itemName, String category, String description, int sortPosition, double price, String image) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.sortPosition = sortPosition;
        this.price = price;
        this.image = image;
    }

    public String getItemId() {

        if (itemId == null) {
            itemId = UUID.randomUUID().toString();
        }
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

//    DataItem(null, "Quinoa Salmon Salad", "Salads",
//                     "Our quinoa salad is served with quinoa, tomatoes, cucumber, scallions, and smoked salmon." +
//                     " Served with your choice of dressing.",
//                     1, 12, "quinoa_salad.jpg")