package com.segmentfinder.strava.segmentsfromstrava.controller;

import com.segmentfinder.strava.segmentsfromstrava.domain.DetailedSegment;
import com.segmentfinder.strava.segmentsfromstrava.service.SegmentService;
import com.segmentfinder.strava.segmentsfromstrava.constants.ControllerConstants;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.BASE_URL + ControllerConstants.API_V1)
@CrossOrigin(value = "http://localhost:3000")
public class SegmentController {

    private static final String SEGMENT_EXPLORER = "/segments";

    private SegmentService segmentService;

    @Autowired
    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    /**
     * Calls the Strava API's fetch service to get the segments within the passed in parameters. It's a middle layer
     * between the maps api and the Strava API.
     *
     * @param bounds latitude and longitude of the selected territory, requires 4 values
     * @return a 200 with a List of maximum 10 segments within the boundaries the passed in bounds parameters
     * if list is empty, then returns a 204 and no content.
     */
    @GetMapping(value = SEGMENT_EXPLORER, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Segment>> getSegmentsBasedOnLongLat(@RequestParam List<String> bounds) {


        List<Segment> segments = segmentService.fetchSegments(bounds);

        System.out.println(segments);

        if (segments == null || segments.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(segments, HttpStatus.OK);
        }
    }

    /**
     *
     * @param id the segment id
     * @return a detailed Segment, meaning more information about the segment
     */
    @GetMapping(value = "/segment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(value = "http://localhost:3000")
    public  ResponseEntity<DetailedSegment> getSegmentDetail(@PathVariable(value="id") Long id) {
        return new ResponseEntity<>(segmentService.fetchSegmentDetail(id), HttpStatus.OK);
    }

}

