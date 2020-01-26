package com.segmentfinder.strava.segmentsfromstrava.service;

import com.segmentfinder.strava.segmentsfromstrava.domain.DetailedSegment;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;

import java.util.List;

public interface SegmentService {

  List<Segment> fetchSegments(List<String> bounds);

  DetailedSegment fetchSegmentDetail(Long id);

  int getAthleteRank(Long id, Integer pageNo, Integer segmentDistance);
}
