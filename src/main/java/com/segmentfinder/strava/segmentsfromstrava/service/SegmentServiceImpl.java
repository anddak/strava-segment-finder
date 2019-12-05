package com.segmentfinder.strava.segmentsfromstrava.service;

import com.segmentfinder.strava.segmentsfromstrava.client.StravaClient;
import com.segmentfinder.strava.segmentsfromstrava.domain.AthleteLeaderboardEntry;
import com.segmentfinder.strava.segmentsfromstrava.domain.DetailedSegment;
import com.segmentfinder.strava.segmentsfromstrava.domain.Leaderboard;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class SegmentServiceImpl implements SegmentService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SegmentServiceImpl.class);

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
   */
  public int matchAthleteTimeWithLeaderboard(Long id, Integer pageNo) {

    //refactor this method and hook it up with controller properly
    //bug when multiple runners with same time  and the next one up has more than one second deficit

    /*
    just hardcoded this one for now
     */
    Integer userTime = 18;
    int userRank = 0;
    int firstSlowerUserRank = 0;

    /*
    get list of entries on leaderboard
     */
    Leaderboard leaderboard = stravaClient.fetchPagedLeaderboard(id, pageNo, 200);
    List<AthleteLeaderboardEntry> entries =leaderboard.getEntries().subList(0, 200);

    /*
    get the first athlete who has a worse time
     */
    AthleteLeaderboardEntry athleteLeaderboardForTime =
            entries.stream().filter(s -> s.getMovingTime() > userTime).findFirst().orElse(null);


    /**
     * loop through the pages until we find the first athlete with a worse time than our user
     */
    while (athleteLeaderboardForTime == null) {

        leaderboard = stravaClient.fetchPagedLeaderboard(id, ++pageNo, 200);
        entries.addAll(leaderboard.getEntries());

        /*
        remove the last 5 elements if athlete done the segment
         */
        entries = removeOwnEntry(entries);

        athleteLeaderboardForTime = entries.stream().filter(s -> s.getMovingTime() > userTime).findFirst().orElse(null);

        LOGGER.info("Leaderboard entries: {}", entries.size());
        LOGGER.info("Slowest time on page: {}", entries.get(entries.size() - 1).getElapsedTime());
      }
    
    /*
    get the above athlete's rank
    if the user time is the same as opponent time, rank is the same
    otherwise, fetch until next rank is found
     */
      if (athleteLeaderboardForTime.getMovingTime().equals(userTime)) {
        userRank = athleteLeaderboardForTime.getRank();
      } else {

        int rank = athleteLeaderboardForTime.getRank();

        Collections.reverse(entries);


          AthleteLeaderboardEntry athleteLeaderboardEntry = entries.stream().filter(s -> s.getRank() < rank).findFirst().orElse(null);

          userRank = entries.size() > 0 && athleteLeaderboardEntry == null ? 1 : athleteLeaderboardEntry.getRank() + 1;
        }



        return userRank;
      }


  /*
  remove the last 5 elements if athlete done the segment
  */
  public List<AthleteLeaderboardEntry> removeOwnEntry(List<AthleteLeaderboardEntry> entries) {

    if (entries.size() % 100 != 0) {
     return entries.subList(0, entries.size() - 5);
    }
    return entries;
  }

}
