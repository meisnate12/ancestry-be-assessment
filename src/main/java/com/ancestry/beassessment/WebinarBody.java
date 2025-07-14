package com.ancestry.beassessment;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WebinarBody {
    private String id = null;
    private String name;
    private int duration = -1;
    private String destURL;
    private @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date timestamp;

    public WebinarBody() {}

    public WebinarBody(String id, String name, int duration, String destURL, Date timestamp) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.destURL = destURL;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDestURL() {
        return destURL;
    }

    public void setDestURL(String destURL) {
        this.destURL = destURL;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}