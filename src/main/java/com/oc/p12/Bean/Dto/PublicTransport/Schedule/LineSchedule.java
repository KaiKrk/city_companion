package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

import java.util.List;

public class LineSchedule {

    List<SchduleDetail> schedules;

    public LineSchedule() {
    }

    public List<SchduleDetail> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<SchduleDetail> schedules) {
        this.schedules = schedules;
    }
}
