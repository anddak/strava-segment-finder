package com.segmentfinder.strava.segmentsfromstrava.domain;

import java.util.HashMap;
import java.util.List;
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
        "start_latlng",
        "end_latlng",
        "distance",
        "starred",
        "country",
        "private",
        "average_grade",
        "maximum_grade",
        "city",
        "end_longitude",
        "athlete_count",
        "hazardous",
        "elevation_high",
        "created_at",
        "end_latitude",
        "total_elevation_gain",
        "athlete_segment_stats",
        "start_longitude",
        "elevation_low",
        "updated_at",
        "start_latitude",
        "activity_type",
        "state",
        "map",
        "effort_count",
        "star_count"
})
public class DetailedSegment {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("resource_state")
    private Integer resourceState;
    @JsonProperty("name")
    private String name;
    @JsonProperty("climb_category")
    private Integer climbCategory;
    @JsonProperty("start_latlng")
    private List<Float> startLatlng = null;
    @JsonProperty("end_latlng")
    private List<Float> endLatlng = null;
    @JsonProperty("distance")
    private Float distance;
    @JsonProperty("starred")
    private Boolean starred;
    @JsonProperty("country")
    private String country;
    @JsonProperty("private")
    private Boolean _private;
    @JsonProperty("average_grade")
    private Float averageGrade;
    @JsonProperty("maximum_grade")
    private Float maximumGrade;
    @JsonProperty("city")
    private String city;
    @JsonProperty("end_longitude")
    private Float endLongitude;
    @JsonProperty("athlete_count")
    private Integer athleteCount;
    @JsonProperty("hazardous")
    private Boolean hazardous;
    @JsonProperty("elevation_high")
    private Float elevationHigh;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("end_latitude")
    private Float endLatitude;
    @JsonProperty("total_elevation_gain")
    private Float totalElevationGain;
    @JsonProperty("athlete_segment_stats")
    private AthleteSegmentStats athleteSegmentStats;
    @JsonProperty("start_longitude")
    private Float startLongitude;
    @JsonProperty("elevation_low")
    private Float elevationLow;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("start_latitude")
    private Float startLatitude;
    @JsonProperty("activity_type")
    private String activityType;
    @JsonProperty("state")
    private String state;
    @JsonProperty("map")
    private DetailedSegmentMap detailedSegmentMap;
    @JsonProperty("effort_count")
    private Integer effortCount;
    @JsonProperty("star_count")
    private Integer starCount;
    @JsonIgnore
    private java.util.Map<String, Object> additionalProperties = new HashMap<>();

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

    @JsonProperty("distance")
    public Float getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Float distance) {
        this.distance = distance;
    }

    @JsonProperty("starred")
    public Boolean getStarred() {
        return starred;
    }

    @JsonProperty("starred")
    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("private")
    public Boolean getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(Boolean _private) {
        this._private = _private;
    }

    @JsonProperty("average_grade")
    public Float getAverageGrade() {
        return averageGrade;
    }

    @JsonProperty("average_grade")
    public void setAverageGrade(Float averageGrade) {
        this.averageGrade = averageGrade;
    }

    @JsonProperty("maximum_grade")
    public Float getMaximumGrade() {
        return maximumGrade;
    }

    @JsonProperty("maximum_grade")
    public void setMaximumGrade(Float maximumGrade) {
        this.maximumGrade = maximumGrade;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("end_longitude")
    public Float getEndLongitude() {
        return endLongitude;
    }

    @JsonProperty("end_longitude")
    public void setEndLongitude(Float endLongitude) {
        this.endLongitude = endLongitude;
    }

    @JsonProperty("athlete_count")
    public Integer getAthleteCount() {
        return athleteCount;
    }

    @JsonProperty("athlete_count")
    public void setAthleteCount(Integer athleteCount) {
        this.athleteCount = athleteCount;
    }

    @JsonProperty("hazardous")
    public Boolean getHazardous() {
        return hazardous;
    }

    @JsonProperty("hazardous")
    public void setHazardous(Boolean hazardous) {
        this.hazardous = hazardous;
    }

    @JsonProperty("elevation_high")
    public Float getElevationHigh() {
        return elevationHigh;
    }

    @JsonProperty("elevation_high")
    public void setElevationHigh(Float elevationHigh) {
        this.elevationHigh = elevationHigh;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("end_latitude")
    public Float getEndLatitude() {
        return endLatitude;
    }

    @JsonProperty("end_latitude")
    public void setEndLatitude(Float endLatitude) {
        this.endLatitude = endLatitude;
    }

    @JsonProperty("total_elevation_gain")
    public Float getTotalElevationGain() {
        return totalElevationGain;
    }

    @JsonProperty("total_elevation_gain")
    public void setTotalElevationGain(Float totalElevationGain) {
        this.totalElevationGain = totalElevationGain;
    }

    @JsonProperty("athlete_segment_stats")
    public AthleteSegmentStats getAthleteSegmentStats() {
        return athleteSegmentStats;
    }

    @JsonProperty("athlete_segment_stats")
    public void setAthleteSegmentStats(AthleteSegmentStats athleteSegmentStats) {
        this.athleteSegmentStats = athleteSegmentStats;
    }

    @JsonProperty("start_longitude")
    public Float getStartLongitude() {
        return startLongitude;
    }

    @JsonProperty("start_longitude")
    public void setStartLongitude(Float startLongitude) {
        this.startLongitude = startLongitude;
    }

    @JsonProperty("elevation_low")
    public Float getElevationLow() {
        return elevationLow;
    }

    @JsonProperty("elevation_low")
    public void setElevationLow(Float elevationLow) {
        this.elevationLow = elevationLow;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("start_latitude")
    public Float getStartLatitude() {
        return startLatitude;
    }

    @JsonProperty("start_latitude")
    public void setStartLatitude(Float startLatitude) {
        this.startLatitude = startLatitude;
    }

    @JsonProperty("activity_type")
    public String getActivityType() {
        return activityType;
    }

    @JsonProperty("activity_type")
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("map")
    public DetailedSegmentMap getDetailedSegmentMap() {
        return detailedSegmentMap;
    }

    @JsonProperty("map")
    public void setMap(DetailedSegmentMap detailedSegmentMap) {
        this.detailedSegmentMap = detailedSegmentMap;
    }

    @JsonProperty("effort_count")
    public Integer getEffortCount() {
        return effortCount;
    }

    @JsonProperty("effort_count")
    public void setEffortCount(Integer effortCount) {
        this.effortCount = effortCount;
    }

    @JsonProperty("star_count")
    public Integer getStarCount() {
        return starCount;
    }

    @JsonProperty("star_count")
    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    @JsonAnyGetter
    public java.util.Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "DetailedSegment{" +
                "id=" + id +
                ", resourceState=" + resourceState +
                ", name='" + name + '\'' +
                ", climbCategory=" + climbCategory +
                ", startLatlng=" + startLatlng +
                ", endLatlng=" + endLatlng +
                ", distance=" + distance +
                ", starred=" + starred +
                ", country='" + country + '\'' +
                ", _private=" + _private +
                ", averageGrade=" + averageGrade +
                ", maximumGrade=" + maximumGrade +
                ", city='" + city + '\'' +
                ", endLongitude=" + endLongitude +
                ", athleteCount=" + athleteCount +
                ", hazardous=" + hazardous +
                ", elevationHigh=" + elevationHigh +
                ", createdAt='" + createdAt + '\'' +
                ", endLatitude=" + endLatitude +
                ", totalElevationGain=" + totalElevationGain +
                ", athleteSegmentStats=" + athleteSegmentStats +
                ", startLongitude=" + startLongitude +
                ", elevationLow=" + elevationLow +
                ", updatedAt='" + updatedAt + '\'' +
                ", startLatitude=" + startLatitude +
                ", activityType='" + activityType + '\'' +
                ", state='" + state + '\'' +
                ", detailedSegmentMap=" + detailedSegmentMap +
                ", effortCount=" + effortCount +
                ", starCount=" + starCount +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
