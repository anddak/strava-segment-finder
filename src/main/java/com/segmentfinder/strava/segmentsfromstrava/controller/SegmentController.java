package com.segmentfinder.strava.segmentsfromstrava.controller;

import com.segmentfinder.strava.segmentsfromstrava.service.SegmentService;
import com.segmentfinder.strava.segmentsfromstrava.constants.ControllerConstants;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.BASE_URL + ControllerConstants.API_V1)
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
   *          if list is empty, then returns a 204 and no content.
   */
  @GetMapping(value = SEGMENT_EXPLORER, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Segment>> getSegmentsBasedOnLongLat(@RequestParam List<String> bounds) {

    List<Segment> segments = segmentService.fetchSegments(bounds);

    if (segments == null || segments.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(segments, HttpStatus.OK);
    }
  }
}
