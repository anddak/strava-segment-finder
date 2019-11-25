package com.segmentfinder.strava.segmentsfromstrava.service;

import com.segmentfinder.strava.segmentsfromstrava.client.StravaClient;
import com.segmentfinder.strava.segmentsfromstrava.domain.DetailedSegment;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SegmentServiceImpl implements SegmentService {

  private StravaClient stravaClient;

  @Autowired
  public SegmentServiceImpl(StravaClient stravaClient) {
    this.stravaClient = stravaClient;
  }

  public List<Segment> fetchSegments(List<String> bounds) {
    return stravaClient.fetchSegments(bounds);
  }



  public DetailedSegment fetchSegmentDetail(Long id) {
    DetailedSegment segment = stravaClient.fetchSegmentDetail(id);

    if (segment.getAthleteSegmentStats().getPrElapsedTime() != null) {
      segment.getAthleteSegmentStats().setAveragePace((int) calculateAthletePaceForSegment(segment));
    }

    System.out.println(segment);
    return segment;
  }

  /**
   * A helper method to calculate the pace of the runner based on the PR time and the segment distance
   * @param segment the detailed segment object
   * @return the pace of the athlete in seconds
   */
  private double calculateAthletePaceForSegment(DetailedSegment segment) {
    return segment.getAthleteSegmentStats().getPrElapsedTime() / (segment.getDistance() / 1000);
  }
}
