package com.ancestry.beassessment;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class WebinarDB {

    @Id
    public String id;

    public String name;
    public int duration;
    public String destURL;
    public Date timestamp;


    public WebinarDB() {}

    public WebinarDB(WebinarBody webinarBody) {
        this.id = webinarBody.getId();
        this.name = webinarBody.getName();
        this.duration = webinarBody.getDuration() == -1 ? 60 : webinarBody.getDuration();
        this.destURL = webinarBody.getDestURL();
        this.timestamp = webinarBody.getTimestamp();
    }

    @Override
    public String toString() {
        return String.format(
                "Webinar[id=%s, name='%s', duration='%s', destURL='%s', timestamp='%s']",
                id, name, duration, destURL, timestamp);
    }

}