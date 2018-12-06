package com.cabshop.my.cabshop;

public class RowItem {

    private int imageId;
    private String title;
    private String price;

    public RowItem(int imageId, String title, String price) {
        this.imageId = imageId;
        this.title = title;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
