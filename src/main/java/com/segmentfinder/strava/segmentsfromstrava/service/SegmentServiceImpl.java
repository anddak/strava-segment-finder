package com.segmentfinder.strava.segmentsfromstrava.service;

import com.segmentfinder.strava.segmentsfromstrava.constants.ControllerConstants;
import com.segmentfinder.strava.segmentsfromstrava.domain.Segment;
import com.segmentfinder.strava.segmentsfromstrava.domain.SegmentList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.StringJoiner;

@Service
public class SegmentServiceImpl implements SegmentService {

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
            .append("?access_token=794417be60552b207a36f2c1829fedfd9851d9bd")
            .append("&bounds=")
            .append(boundsString)
            .append("&activity_type=running");
    //TODO: authorization instead of hardcoding access_token
    //TODO: string variables instead of multiple appends: https://www.leveluplunch.com/java/examples/construct-build-uri/

    SegmentList response = restTemplate.getForObject(url.toString(), SegmentList.class);
    return response != null ? response.getSegments() : null;
  }
}
