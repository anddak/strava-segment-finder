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
        "pr_elapsed_time",
        "pr_date",
        "effort_count",
})
public class AthleteSegmentStats {

    @JsonProperty("pr_elapsed_time")
    private Integer prElapsedTime;
    @JsonProperty("pr_date")
    private String prDate;
    @JsonProperty("effort_count")
    private Integer effortCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonIgnore
    @JsonProperty("average_pace")
    private int averagePace;

    @JsonProperty("average_pace")
    public int getAveragePace() {
        return averagePace;
    }

    @JsonProperty("average_pace")
    public void setAveragePace(int averagePace) {
        this.averagePace = averagePace;
    }

    @JsonProperty("pr_elapsed_time")
    public Integer getPrElapsedTime() {
        return prElapsedTime;
    }

    @JsonProperty("pr_elapsed_time")
    public void setPrElapsedTime(Integer prElapsedTime) {
        this.prElapsedTime = prElapsedTime;
    }

    @JsonProperty("pr_date")
    public String getPrDate() {
        return prDate;
    }

    @JsonProperty("pr_date")
    public void setPrDate(String prDate) {
        this.prDate = prDate;
    }

    @JsonProperty("effort_count")
    public Integer getEffortCount() {
        return effortCount;
    }

    @JsonProperty("effort_count")
    public void setEffortCount(Integer effortCount) {
        this.effortCount = effortCount;
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
        return "AthleteSegmentStats{" +
                "prElapsedTime=" + prElapsedTime +
                ", prDate='" + prDate + '\'' +
                ", effortCount=" + effortCount +
                ", additionalProperties=" + additionalProperties +
                ", averagePace=" + averagePace +
                '}';
    }
}

