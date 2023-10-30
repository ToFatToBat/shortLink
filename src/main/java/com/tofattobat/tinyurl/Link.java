package com.tofattobat.tinyurl;

public class Link {
    private String id;
    private String Name;
    private  String targetURL;
    private int visits;

    public Link() {
    }

    public Link(String id, String name, String targetURL) {
        this.id = id;
        Name = name;
        this.targetURL = targetURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTargetURL() {
        return targetURL;
    }

    public void setTargetURL(String targetURL) {
        this.targetURL = targetURL;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }
}
