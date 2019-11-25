package com.segmentfinder.strava.segmentsfromstrava.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "resource_state",
        "name",
        "climb_category",
        "climb_category_desc",
        "avg_grade",
        "start_latlng",
        "end_latlng",
        "elev_difference",
        "distance",
        "points",
        "starred"
})
public class Segment {

  @JsonProperty("id")
  private Integer id;
  @JsonProperty("resource_state")
  private Integer resourceState;
  @JsonProperty("name")
  private String name;
  @JsonProperty("climb_category")
  private Integer climbCategory;
  @JsonProperty("climb_category_desc")
  private String climbCategoryDesc;
  @JsonProperty("avg_grade")
  private Integer avgGrade;
  @JsonProperty("start_latlng")
  private List<Float> startLatlng = null;
  @JsonProperty("end_latlng")
  private List<Float> endLatlng = null;
  @JsonProperty("elev_difference")
  private Float elevDifference;
  @JsonProperty("distance")
  private Float distance;
  @JsonProperty("points")
  private String points;
  @JsonProperty("starred")
  private Boolean starred;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  @JsonProperty("resource_state")
  public Integer getResourceState() {
    return resourceState;
  }

  @JsonProperty("resource_state")
  public void setResourceState(Integer resourceState) {
    this.resourceState = resourceState;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("climb_category")
  public Integer getClimbCategory() {
    return climbCategory;
  }

  @JsonProperty("climb_category")
  public void setClimbCategory(Integer climbCategory) {
    this.climbCategory = climbCategory;
  }

  @JsonProperty("climb_category_desc")
  public String getClimbCategoryDesc() {
    return climbCategoryDesc;
  }

  @JsonProperty("climb_category_desc")
  public void setClimbCategoryDesc(String climbCategoryDesc) {
    this.climbCategoryDesc = climbCategoryDesc;
  }

  @JsonProperty("avg_grade")
  public Integer getAvgGrade() {
    return avgGrade;
  }

  @JsonProperty("avg_grade")
  public void setAvgGrade(Integer avgGrade) {
    this.avgGrade = avgGrade;
  }

  @JsonProperty("start_latlng")
  public List<Float> getStartLatlng() {
    return startLatlng;
  }

  @JsonProperty("start_latlng")
  public void setStartLatlng(List<Float> startLatlng) {
    this.startLatlng = startLatlng;
  }

  @JsonProperty("end_latlng")
  public List<Float> getEndLatlng() {
    return endLatlng;
  }

  @JsonProperty("end_latlng")
  public void setEndLatlng(List<Float> endLatlng) {
    this.endLatlng = endLatlng;
  }

  @JsonProperty("elev_difference")
  public Float getElevDifference() {
    return elevDifference;
  }

  @JsonProperty("elev_difference")
  public void setElevDifference(Float elevDifference) {
    this.elevDifference = elevDifference;
  }

  @JsonProperty("distance")
  public Float getDistance() {
    return distance;
  }

  @JsonProperty("distance")
  public void setDistance(Float distance) {
    this.distance = distance;
  }

  @JsonProperty("points")
  public String getPoints() {
    return points;
  }

  @JsonProperty("points")
  public void setPoints(String points) {
    this.points = points;
  }

  @JsonProperty("starred")
  public Boolean getStarred() {
    return starred;
  }

  @JsonProperty("starred")
  public void setStarred(Boolean starred) {
    this.starred = starred;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "Segment{" +
            "id=" + id +
            ", resourceState=" + resourceState +
            ", name='" + name + '\'' +
            ", climbCategory=" + climbCategory +
            ", climbCategoryDesc='" + climbCategoryDesc + '\'' +
            ", avgGrade=" + avgGrade +
            ", startLatlng=" + startLatlng +
            ", endLatlng=" + endLatlng +
            ", elevDifference=" + elevDifference +
            ", distance=" + distance +
            ", points='" + points + '\'' +
            ", starred=" + starred +
            ", additionalProperties=" + additionalProperties +
            '}';
  }
}