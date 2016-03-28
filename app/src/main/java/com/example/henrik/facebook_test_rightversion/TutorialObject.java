package com.example.henrik.facebook_test_rightversion;


public class TutorialObject {
    private String title;

    private String url;

    private String upploader;

    private int img;

    public TutorialObject(String title, String upploader, String url, int img) {
        this.title = title;
        this.url = url;
        this.img = img;
        this.upploader = upploader;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getImg() {
        return img;
    }

    public String getUpploader(){
        return upploader;
    }
}
