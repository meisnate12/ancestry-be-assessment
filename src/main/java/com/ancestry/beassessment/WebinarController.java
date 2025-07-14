package com.ancestry.beassessment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebinarController {

    @Autowired
    private WebinarRepository repository;

    @GetMapping("/webinar")
    public List<WebinarDB> getWebinar(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fromDate,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date toDate
    )
    {
        List<WebinarDB> webinars = new ArrayList<>();
        int count = 0;
        for (WebinarDB webinar : repository.findAll()) {
            if (
                    (limit == null || limit <= 0 || count < limit) &&
                    (fromDate == null || webinar.timestamp.after(fromDate)) &&
                    (toDate == null || webinar.timestamp.before(toDate))
            ) {
                webinars.add(webinar);
                count++;
            }
        }
        return webinars;
    }

    @PostMapping("/webinar")
    public WebinarDB createWebinar(@RequestBody WebinarBody webinarBody) {
        WebinarDB webinardb = new WebinarDB(webinarBody);
        repository.save(webinardb);
        return webinardb;
    }

    @PutMapping("/webinar")
    public WebinarDB updateWebinar(@RequestBody WebinarBody webinarBody) {
        WebinarDB db_web = repository.findById(webinarBody.getId()).orElseThrow(() -> new RuntimeException("webinar not found"));
        if (webinarBody.getName() != null) {
            db_web.name = webinarBody.getName();
        }
        if (webinarBody.getDuration() > 0) {
            db_web.duration = webinarBody.getDuration();
        }
        if (webinarBody.getDestURL() != null) {
            db_web.destURL = webinarBody.getDestURL();
        }
        if (webinarBody.getTimestamp() != null) {
            db_web.timestamp = webinarBody.getTimestamp();
        }

        repository.save(db_web);
        return db_web;
    }

    @DeleteMapping("/webinar")
    public void deleteWebinar(@RequestParam(value = "id") String webinarID) {
        repository.deleteById(webinarID);
    }

}