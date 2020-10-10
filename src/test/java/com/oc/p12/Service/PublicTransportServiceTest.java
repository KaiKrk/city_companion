package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleResponse;
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

        String line = "14";

        String station = "chatelet";

        PublicTransportScheduleResponse publicTransportScheduleResponse = publicTransportService.fetchTrafficSchedule(transportType,line,station);
        System.out.println(publicTransportScheduleResponse);
        assertThat(publicTransportScheduleResponse.getResult().getSchedules()!= null);
    }
}
