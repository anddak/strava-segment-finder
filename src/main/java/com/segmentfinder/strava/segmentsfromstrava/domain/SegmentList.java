package com.segmentfinder.strava.segmentsfromstrava.domain;

import java.util.List;

/**
 * A wrapper class for calling the segment explorer because Strava's API is returning an object with a list of objects,
 * hence we need the wrapper to model the top level object.
 */
public class SegmentList {

  private List<Segment> segments;

  public SegmentList(List<Segment> segments) {
    this.segments = segments;
  }

  public SegmentList() {
  }

  public List<Segment> getSegments() {
    return segments;
  }

  public void setSegments(List<Segment> segments) {
    this.segments = segments;
  }
}
