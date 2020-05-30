package com.example.govimithuru;

public class carrotact {
    String name,quantity,price,location,expire,image;

    public carrotact() {
    }

    public carrotact(String name, String quantity, String price, String location, String expire, String image) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.location = location;
        this.expire = expire;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
