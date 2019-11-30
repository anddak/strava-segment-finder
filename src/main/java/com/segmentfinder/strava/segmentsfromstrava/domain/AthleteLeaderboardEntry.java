package com.segmentfinder.strava.segmentsfromstrava.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "athlete_name",
        "elapsed_time",
        "moving_time",
        "start_date",
        "start_date_local",
        "rank"
})
public class AthleteLeaderboardEntry {

    @JsonProperty("athlete_name")
    private String athleteName;
    @JsonProperty("elapsed_time")
    private Integer elapsedTime;
    @JsonProperty("moving_time")
    private Integer movingTime;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("start_date_local")
    private String startDateLocal;
    @JsonProperty("rank")
    private Integer rank;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("athlete_name")
    public String getAthleteName() {
        return athleteName;
    }

    @JsonProperty("athlete_name")
    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    @JsonProperty("elapsed_time")
    public Integer getElapsedTime() {
        return elapsedTime;
    }

    @JsonProperty("elapsed_time")
    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @JsonProperty("moving_time")
    public Integer getMovingTime() {
        return movingTime;
    }

    @JsonProperty("moving_time")
    public void setMovingTime(Integer movingTime) {
        this.movingTime = movingTime;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("start_date_local")
    public String getStartDateLocal() {
        return startDateLocal;
    }

    @JsonProperty("start_date_local")
    public void setStartDateLocal(String startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
