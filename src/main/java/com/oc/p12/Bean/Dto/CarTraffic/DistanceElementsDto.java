package com.oc.p12.Bean.Dto.CarTraffic;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.geo.Distance;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DistanceElementsDto {

    private DistanceDto distance;

    private DurationDto duration;

    private DurationInTrafficDto durationInTraffic;

    public DistanceElementsDto() {
    }

    public DistanceDto getDistance() {
        return distance;
    }

    public void setDistance(DistanceDto distance) {
        this.distance = distance;
    }

    public DurationDto getDuration() {
        return duration;
    }

    public void setDuration(DurationDto duration) {
        this.duration = duration;
    }

    public DurationInTrafficDto getDurationInTraffic() {
        return durationInTraffic;
    }

    public void setDurationInTraffic(DurationInTrafficDto durationInTraffic) {
        this.durationInTraffic = durationInTraffic;
    }

    @Override
    public String toString() {
        return "DistanceElementsDto{" +
                "distance=" + distance +
                ", duration=" + duration +
                ", durationInTraffic=" + durationInTraffic +
                '}';
    }
}
