package com.segmentfinder.strava.segmentsfromstrava.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 *  model class for a segment fetched from Strava using Strava's segment explore endpoint which returns an instance of
 *  Strava's ExplorerResponse entity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {

  /**
   * The unique identifier of the segment
   */
  private long id;

  /**
   * 	The name of the segment
   */
  private String name;

  /**
   * The category of the climb [0, 5]. Higher is harder ie. 5 is Hors catégorie, 0 is uncategorized in climb_category.
   * If climb_category = 5, climb_category_desc = HC. If climb_category = 2, climb_category_desc = 3.
   */
  private int climbCategory;

  /**
   * The description for the category of the climb May take one of the following values: NC, 4, 3, 2, 1, HC
   */
  private String climbCategoryDesc;

  /**
   * The segment's average grade, in percents.
   */
  private double avgGrade;

  /**
   * A collection of float objects. A pair of latitude/longitude coordinates,
   * represented as an array of 2 floating point numbers.
   */
  private List startLatLong;
  private List endLatLong;

  /**
   * The segments's evelation difference, in meters
   */
  private double elevationDifference;

  /**
   * The segment's distance, in meters
   */
  private double distance;

  /**
   * The polyline of the segment
   */
  private String points;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getClimbCategory() {
    return climbCategory;
  }

  public String getClimbCategoryDesc() {
    return climbCategoryDesc;
  }

  public double getAvgGrade() {
    return avgGrade;
  }

  public List getStartLatLong() {
    return startLatLong;
  }

  public List getEndLatLong() {
    return endLatLong;
  }

  public double getElevationDifference() {
    return elevationDifference;
  }

  public double getDistance() {
    return distance;
  }

  public String getPoints() {
    return points;
  }

  @Override
  public String toString() {
    return "Segment{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", climbCategory=" + climbCategory +
            ", climbCategoryDesc='" + climbCategoryDesc + '\'' +
            ", avgGrade=" + avgGrade +
            ", startLatLong=" + startLatLong +
            ", endLatLong=" + endLatLong +
            ", elevationDifference=" + elevationDifference +
            ", distance=" + distance +
            ", points='" + points + '\'' +
            '}';
  }
}
