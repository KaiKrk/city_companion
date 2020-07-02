package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

import java.util.List;

public class LineSchedule {

    List<ScheduleDetail> schedules;

    public LineSchedule() {
    }

    public List<ScheduleDetail> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDetail> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "LineSchedule{" +
                "schedules=" + schedules +
                '}';
    }
}
