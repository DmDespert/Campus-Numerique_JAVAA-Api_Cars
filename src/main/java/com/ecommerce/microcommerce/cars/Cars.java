package com.ecommerce.microcommerce.cars;

import java.util.Objects;

public class Cars {
    private int id;
    private String model;
    private String marque;
    private String color;

    public Cars() {}

    public Cars(int id, String model, String marque, String color) {
        this.id = id;
        this.model = model;
        this.marque = marque;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{"+
                "id=" + id +
                ", model=" + model +
                ", marque=" + marque +
                ", color=" + color +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return id == cars1.id && Objects.equals(model, cars1.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model);
    }
}
