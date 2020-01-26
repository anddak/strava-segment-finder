package com.segmentfinder.strava.segmentsfromstrava.service;

import com.segmentfinder.strava.segmentsfromstrava.client.StravaClient;
import com.segmentfinder.strava.segmentsfromstrava.domain.AthleteLeaderboardEntry;
import com.segmentfinder.strava.segmentsfromstrava.domain.DetailedSegment;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;
import com.segmentfinder.strava.segmentsfromstrava.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class SegmentServiceImpl implements SegmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentServiceImpl.class);
    AthleteLeaderboardEntry athleteLeaderboardEntry;
    List<AthleteLeaderboardEntry> entries = new ArrayList<>();
    private StravaClient stravaClient;
    private UserRepository userRepository;

    public SegmentServiceImpl(StravaClient stravaClient, UserRepository userRepository) {
        this.stravaClient = stravaClient;
        this.userRepository = userRepository;
    }

    public List<Segment> fetchSegments(List<String> bounds) {
        return stravaClient.fetchSegments(bounds);
    }


    public DetailedSegment fetchSegmentDetail(Long id) {

        DetailedSegment segment = stravaClient.fetchSegmentDetail(id);

        calculateSegmentPaceIfAthleteHaveSegmentCompletion(segment);

        return segment;
    }

    private void calculateSegmentPaceIfAthleteHaveSegmentCompletion(DetailedSegment segment) {
        if (segment.getAthleteSegmentStats().getPrElapsedTime() != null) {
            segment.getAthleteSegmentStats().setAveragePace((int) calculateAthletePaceForSegment(segment));
        }
    }

    /**
     * A helper method to calculate the pace of the runner based on the PR time and the segment distance
     *
     * @param segment the detailed segment object
     * @return the pace of the athlete in seconds
     */
    private double calculateAthletePaceForSegment(DetailedSegment segment) {
        return segment.getAthleteSegmentStats().getPrElapsedTime() / (segment.getDistance() / 1000);
    }


    public int getAthleteRank(Long id, Integer pageNo, Integer segmentDistance) {

        // temporarily hardcoded the below two
        int userTime = userRepository.getUserTime();
        int userTimeOnSegment = (segmentDistance / 100) * userTime;


        athleteLeaderboardEntry = loadLeaderboardEntryPagesUntilFirstSlowerOrEqualAthleteIsFound(id, pageNo, userTimeOnSegment, entries);

        return isUserTimeEqualWithAnotherAthlete(userTimeOnSegment) ?
                athleteLeaderboardEntry.getRank()
                : getUserRankIfSegmentTimeIsUnique();

    }

    private int getUserRankIfSegmentTimeIsUnique() {
        int rank = athleteLeaderboardEntry.getRank();
       return (!entries.isEmpty()) && findPositionOfFirstSlowerAthlete(rank) == null ? 1 : findPositionOfFirstSlowerAthlete(rank).getRank();
    }

    private AthleteLeaderboardEntry findPositionOfFirstSlowerAthlete(int rank) {
        Collections.reverse(entries);
        return entries.stream().filter(s -> s.getRank() < rank).findFirst().orElse(null);
    }

    private boolean isUserTimeEqualWithAnotherAthlete(int userTimeOnSegment) {
        return athleteLeaderboardEntry.getMovingTime().equals(userTimeOnSegment);
    }

    private AthleteLeaderboardEntry loadLeaderboardEntryPagesUntilFirstSlowerOrEqualAthleteIsFound(Long id, Integer pageNo, int userTimeOnSegment, List<AthleteLeaderboardEntry> entries) {
        while ((athleteLeaderboardEntry = getFirstAthleteWithWorseTimeThanUser(userTimeOnSegment, entries)) == null) {

            entries.addAll(getSegmentLeaderboardByPage(id, ++pageNo));
            entries = removeOwnResultFromSegment(entries);

            LOGGER.info("Leaderboard entries: {}", entries.size());
            LOGGER.info("Slowest time on page: {}", entries.get(entries.size() - 1).getElapsedTime());
        }
        return athleteLeaderboardEntry;
    }

    private List<AthleteLeaderboardEntry> getSegmentLeaderboardByPage(Long id, Integer pageNo) {
        return stravaClient.fetchPagedLeaderboard(id, pageNo, 200).getEntries();
    }

    private AthleteLeaderboardEntry getFirstAthleteWithWorseTimeThanUser(int userTimeOnSegment, List<AthleteLeaderboardEntry> entries) {
        return entries == null ? null : entries.stream().filter(s -> s.getMovingTime() > userTimeOnSegment).findFirst().orElse(null);
    }

    private List<AthleteLeaderboardEntry> removeOwnResultFromSegment(List<AthleteLeaderboardEntry> entries) {
        return entries.size() % 100 != 0 ? entries.subList(0, entries.size() - 5) : entries;
    }

}

//TODO: bug when multiple runners with same time  and the next one up has more than one second deficit
