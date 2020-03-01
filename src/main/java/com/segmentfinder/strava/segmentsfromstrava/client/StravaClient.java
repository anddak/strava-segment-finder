package com.segmentfinder.strava.segmentsfromstrava.client;

import com.segmentfinder.strava.segmentsfromstrava.constants.ControllerConstants;
import com.segmentfinder.strava.segmentsfromstrava.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.StringJoiner;

@Component
public class StravaClient {

    public static final String ACCESS_TOKEN = ""; //create env file for security reasons

    private RestTemplate restTemplate = new RestTemplate();

    /**
     *  Service method to call the Strava API with the bound parameters what is passed in from the local endpoint.
     *  A layer to connect the applications controller with the Strava endpoint.
     *
     * @param bounds latitude and longitude of the selected zone on map, requires 4 values
     * @return a List of maximum 10 segments within the boundaries the passed in bounds parameters
     */
    public List<Segment> fetchSegments(List<String> bounds) {

        StringJoiner boundsString = new StringJoiner(",");
        bounds.forEach(boundsString::add);

        StringBuilder url = new StringBuilder(ControllerConstants.STRAVA_BASE_URL)
                .append(ControllerConstants.STRAVA_SEGMENTS)
                .append("/explore")
                .append("?access_token=")
                .append(ACCESS_TOKEN)
                .append("&bounds=")
                .append(boundsString)
                .append("&activity_type=running");
        //TODO: authorization instead of hardcoding access_token
        //TODO: string variables instead of multiple appends: https://www.leveluplunch.com/java/examples/construct-build-uri/

        SegmentList response = restTemplate.getForObject(url.toString(), SegmentList.class);
        return response != null ? response.getSegments() : null;
    }

    /**
     *
     * @param id the segment id
     * @return a response from the Strava API that is a Segment but in more detail
     */
    public DetailedSegment fetchSegmentDetail(Long id) {
        StringBuilder url = new StringBuilder(ControllerConstants.STRAVA_BASE_URL)
                .append(ControllerConstants.STRAVA_SEGMENTS)
                .append("/")
                .append(id)
                .append("?access_token=")
                .append(ACCESS_TOKEN);

        return restTemplate.getForObject(url.toString(), DetailedSegment.class);


    }

    /**
     *
     * Client to call the leaderboard for a given segment
     *
     * @param id segment id
     * @param pageNo pageNo
     * @param perPage number of athletes on one page
     * @return
     */
    public Leaderboard fetchPagedLeaderboard(Long id, Integer pageNo, Integer perPage) {
        StringBuilder url = new StringBuilder(ControllerConstants.STRAVA_BASE_URL)
                .append(ControllerConstants.STRAVA_SEGMENTS)
                .append("/")
                .append(id)
                .append("/leaderboard")
                .append("?page=")
                .append(pageNo)
                .append("&per_page=")
                .append(perPage)
                .append("&access_token=")
                .append(ACCESS_TOKEN);

        return restTemplate.getForObject(url.toString(), Leaderboard.class);
    }

}
