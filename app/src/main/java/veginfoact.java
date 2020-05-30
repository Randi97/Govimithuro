package com.example.govimithuru;

public class veginfoact {
    public String Name,quantity,price,location;

    public String imageURL;

    public veginfoact() {

    }

    public veginfoact(String name, String url,String quantity, String price, String location) {

        this.Name = name;
        this.quantity = quantity;
        this.price = price;
        this.location = location;
        this.imageURL= url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
