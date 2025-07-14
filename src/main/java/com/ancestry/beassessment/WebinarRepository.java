package com.ancestry.beassessment;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebinarRepository extends MongoRepository<WebinarDB, String> {

    public List<WebinarDB> findByTimestampBetween(Date startDate, Date endDate);

}