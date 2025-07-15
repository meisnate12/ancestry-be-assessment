package com.ancestry.beassessment;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


@SpringBootApplication
public class AncestryBeAssessmentApplication implements CommandLineRunner {

    @PostConstruct
    public void setToUtc() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(AncestryBeAssessmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
