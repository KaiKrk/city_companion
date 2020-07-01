package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleDto;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PublicTransportService {

    private String publicTransportApiUrl = "https://api-ratp.pierre-grimaud.fr/v4";
    private RestTemplate restTemplate = new RestTemplate();

    public TrafficInfoDto getTrafficInformation(String transportType ,String line){

        ResponseEntity<TrafficInfoDto> trafficInfo = restTemplate.getForEntity(publicTransportApiUrl+"/traffic/"+transportType+"/"+line, TrafficInfoDto.class);
        return trafficInfo.getBody();
    }

    public PublicTransportScheduleDto getTrafficSchedule(String transportType, String line, String station){
        ResponseEntity<PublicTransportScheduleDto> trafficSchedule =  restTemplate.getForEntity(publicTransportApiUrl+"/schedules/"+transportType+"/"+line+"/"+station+"/A+R", PublicTransportScheduleDto.class);
        return trafficSchedule.getBody();
    }
}
