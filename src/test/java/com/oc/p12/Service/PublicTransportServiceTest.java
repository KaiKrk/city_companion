package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportSchedule;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublicTransportServiceTest {

    @Autowired
    PublicTransportService publicTransportService;

    @Test
    public void getTrafficInfoTest(){
        String transportType = "metros";

        String line = "8";

        TrafficInfoDto trafficInfoDto = publicTransportService.getTrafficInformation(transportType,line);
        System.out.println(trafficInfoDto);
    }

    @Test
    public void getSchedule(){
        String transportType = "metros";

        String line = "14";

        String station = "chatelet";

        PublicTransportSchedule publicTransportSchedule = publicTransportService.getTrafficSchedule(transportType,line,station);
        System.out.println(publicTransportSchedule);
    }
}
