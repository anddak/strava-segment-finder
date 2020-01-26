package com.segmentfinder.strava.segmentsfromstrava.service;

import com.segmentfinder.strava.segmentsfromstrava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private int distanceUnit;
    private int timeUnit;

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * registers the user time with the corresponding distance
     * @param timeInSeconds the users best effort in seconds
     */
    @Override
    public void calculateBestEffort(Integer timeInSeconds, Integer distance) {

        //apply algorithm based on the spreadsheet I downloaded, for now we just use a dummy formula

        distanceUnit = distance/100;

        /**
         * time unit is seconds per 100m
         */
        timeUnit = timeInSeconds/distanceUnit;


         userRepository.logBestEffort(timeUnit);
    }
}
