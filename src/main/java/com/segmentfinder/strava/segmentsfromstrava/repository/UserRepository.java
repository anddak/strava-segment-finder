package com.segmentfinder.strava.segmentsfromstrava.repository;

import org.springframework.stereotype.Repository;

/**
 *  this is just hardwired for now
 */
@Repository
public class UserRepository {

    /**
     * dummy calculation for 100m unit
     */
    private int userTime;


    public void logBestEffort(Integer timeUnit) {
        userTime = timeUnit;
    }

    public int getUserTime() {
        return userTime;
    }
}
