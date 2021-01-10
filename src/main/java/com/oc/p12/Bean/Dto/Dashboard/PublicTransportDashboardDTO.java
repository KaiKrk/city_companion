package com.oc.p12.Bean.Dto.Dashboard;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleResponse;
import com.oc.p12.Bean.Dto.PublicTransport.Schedule.ScheduleDetail;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfoResponse;
import com.oc.p12.Entity.TransportInfo;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class PublicTransportDashboardDTO {

    public String station;
    public String lineStatus;
    public List<ScheduleDetail> nextDepartures;

    public PublicTransportDashboardDTO() {
    }

    public PublicTransportDashboardDTO(TransportInfo tf, PublicTransportScheduleResponse ptsr, TrafficInfoResponse tir){
        this.station = tf.getDepartureStop();
        this.lineStatus = tir.getResult().getTitle();
        for (ScheduleDetail schedule : ptsr.getResult().getSchedules()
             ) {
            this.nextDepartures.add( new ScheduleDetail( schedule.getMessage(),schedule.getDestination()));
        }

    }

}
