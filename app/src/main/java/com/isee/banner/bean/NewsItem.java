package com.isee.banner.bean;

public class NewsItem{
    private String title;
    private int imageUrl;
    private String remoteImage;

    public String getRemoteImage() {
        return remoteImage;
    }

    public void setRemoteImage(String remoteImage) {
        this.remoteImage = remoteImage;
    }

    public NewsItem(String title, int imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }
    public NewsItem(String title, String remoteImage) {
        this.title = title;
        this.remoteImage = remoteImage;
    }

    public NewsItem(String title, int imageUrl, String remoteImage) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.remoteImage = remoteImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
