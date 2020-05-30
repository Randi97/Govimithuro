package com.example.govimithuru;

public class Farmeract {

    String name,location,vegetable,image,contact;

    public Farmeract() {
    }

    public Farmeract(String name, String location, String vegetable, String image, String contact) {
        this.name = name;
        this.location = location;
        this.vegetable = vegetable;
        this.contact = contact;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVegetable() {
        return vegetable;
    }

    public void setVegetable(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getImage() {
        return image;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
