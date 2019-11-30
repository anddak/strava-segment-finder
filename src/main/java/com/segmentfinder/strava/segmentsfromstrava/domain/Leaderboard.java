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
        "effort_count",
        "entry_count",
        "kom_type",
        "entries"
})
public class Leaderboard {

    @JsonProperty("effort_count")
    private Integer effortCount;
    @JsonProperty("entry_count")
    private Integer entryCount;
    @JsonProperty("kom_type")
    private String komType;
    @JsonProperty("entries")
    private List<AthleteLeaderboardEntry> entries = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("effort_count")
    public Integer getEffortCount() {
        return effortCount;
    }

    @JsonProperty("effort_count")
    public void setEffortCount(Integer effortCount) {
        this.effortCount = effortCount;
    }

    @JsonProperty("entry_count")
    public Integer getEntryCount() {
        return entryCount;
    }

    @JsonProperty("entry_count")
    public void setEntryCount(Integer entryCount) {
        this.entryCount = entryCount;
    }

    @JsonProperty("kom_type")
    public String getKomType() {
        return komType;
    }

    @JsonProperty("kom_type")
    public void setKomType(String komType) {
        this.komType = komType;
    }

    @JsonProperty("entries")
    public List<AthleteLeaderboardEntry> getEntries() {
        return entries;
    }

    @JsonProperty("entries")
    public void setEntries(List<AthleteLeaderboardEntry> entries) {
        this.entries = entries;
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
