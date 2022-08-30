package com.example.fitwithit;

public class HomepageItem {

    private int ImageResID;
    private String title;
    private String desc;

    public HomepageItem(int imageResID, String title, String desc) {
        ImageResID = imageResID;
        this.title = title;
        this.desc = desc;
    }
    public HomepageItem()
    {

    }

    public int getImageResID() {
        return ImageResID;
    }

    public void setImageResID(int imageResID) {
        ImageResID = imageResID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
