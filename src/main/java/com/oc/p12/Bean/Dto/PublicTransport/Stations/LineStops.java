package com.oc.p12.Bean.Dto.PublicTransport.Stations;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.ScheduleDetail;

import java.util.List;

public class LineStops {

    List<Station> stations;

    public LineStops() {
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setSchedules(List<Station> schedules) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "LineSchedule{" +
                "stations=" + stations +
                '}';
    }
}
