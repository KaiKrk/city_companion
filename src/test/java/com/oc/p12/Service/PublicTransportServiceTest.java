package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleResponse;
import com.oc.p12.Bean.Dto.PublicTransport.Stations.PublicTransportStationsResponse;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class PublicTransportServiceTest {

    @Autowired
    PublicTransportService publicTransportService;

    @Test
    public void getTrafficInfoTest(){
        String transportType = "metros";
        String line = "1";

        TrafficInfoResponse trafficInfoResponse = publicTransportService.fetchTrafficInformation(transportType,line);
        System.out.println(trafficInfoResponse);
        assertThat(trafficInfoResponse.getResult().getLine()).isEqualTo(line);
    }

    @Test
    public void getSchedule(){
        String transportType = "metros";

        String line = "8";

        String station = "Liberté";

        PublicTransportScheduleResponse publicTransportScheduleResponse = publicTransportService.fetchTrafficSchedule(transportType,line,station);
        System.out.println(publicTransportScheduleResponse);
        assertThat(publicTransportScheduleResponse.getResult().getSchedules()!= null);
    }

    @Test
    public void getLineStations(){
        String transportType = "buses";

        String line = "84";

        PublicTransportStationsResponse publicTransportStationsResponse = publicTransportService.getLineStations(transportType,line);
        System.out.println(publicTransportStationsResponse);
        assertThat(publicTransportStationsResponse.getResult().getStations()!= null);
    }
}
