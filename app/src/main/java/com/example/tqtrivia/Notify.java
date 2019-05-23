package com.example.tqtrivia;

public class Notify {

    private String title, description, hashtag, time, location;

    public Notify(){
        //Empty Constructor
    }

    public Notify(String title, String description, String hashtag, String time, String location) {
        this.title = title;
        this.description = description;
        this.hashtag = hashtag;
        this.time = time;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }
}
