package com.segmentfinder.strava.segmentsfromstrava.controller;

import com.segmentfinder.strava.segmentsfromstrava.constants.ControllerConstants;
import com.segmentfinder.strava.segmentsfromstrava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerConstants.BASE_URL + ControllerConstants.API_V1)
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    private static final String USER = "/user";

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param timeInSeconds user best estimated effort in distance
     * @param distance the distance associated with the best effort
     * @return
     */
    @PostMapping(value = USER + "/effort")
    public ResponseEntity submitUserTime(@RequestParam Integer timeInSeconds, @RequestParam Integer distance) {
        try {
            userService.calculateBestEffort(timeInSeconds, distance);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
