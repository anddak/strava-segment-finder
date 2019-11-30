package com.segmentfinder.strava.segmentsfromstrava.service;

import com.segmentfinder.strava.segmentsfromstrava.client.StravaClient;
import com.segmentfinder.strava.segmentsfromstrava.domain.AthleteLeaderboardEntry;
import com.segmentfinder.strava.segmentsfromstrava.domain.DetailedSegment;
import com.segmentfinder.strava.segmentsfromstrava.domain.Leaderboard;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

  /**
   *
   * @param id
   * @param pageNo
   * @param pageSize
   */
  private void matchAthleteTimeWithLeaderboard(Long id, Integer pageNo, Integer pageSize) {

    /*
    just hardcoded this one for now
     */
    Integer userTime = 200;

    /*
    get list of entries on leaderboard
     */
    Leaderboard leaderboard = stravaClient.fetchPagedLeaderboard(id, pageNo, pageSize);
    List<AthleteLeaderboardEntry> entries =leaderboard.getEntries();

    /*
    get the first athlete who has a worse time
     */
    AthleteLeaderboardEntry athleteLeaderboardForTime =
            entries.stream().filter(s -> s.getMovingTime() > userTime).findFirst().orElse(null);

    /*
    get the above athlete's rank
    et the rank before, that would be the users position
     */
    if (athleteLeaderboardForTime != null) {
      int rank = athleteLeaderboardForTime.getRank();
      Collections.reverse(entries);
      AthleteLeaderboardEntry athleteLeaderboardEntryForRank
              = entries.stream().filter(s -> s.getRank() > rank).findFirst().orElse(null);

      /*
      user potential rank
       */
      int userRank = athleteLeaderboardEntryForRank.getRank();
    }








  }

}
