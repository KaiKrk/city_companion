package com.oc.p12.Bean.Dto.Dashboard;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleResponse;
import com.oc.p12.Bean.Dto.PublicTransport.Schedule.ScheduleDetail;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfoResponse;
import com.oc.p12.Entity.TransportInfo;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class PublicTransportDashboardDTO {

    public String transportType;
    public String transportLine;
    public String station;
    public String lineStatus;
    public List<ScheduleDetail> nextDepartures = new ArrayList<>();

    public PublicTransportDashboardDTO() {
    }

    public PublicTransportDashboardDTO(String transportType, String line, TransportInfo tf, PublicTransportScheduleResponse ptsr, TrafficInfoResponse tir){
        this.transportType = transportType;
        this.transportLine = line;
        this.station = tf.getDepartureStop();
        this.lineStatus = tir.getResult().getTitle();
        for (ScheduleDetail schedule : ptsr.getResult().getSchedules()
             ) {
            System.out.println("schedule " +schedule);
            this.nextDepartures.add(schedule);
        }

    }

}
