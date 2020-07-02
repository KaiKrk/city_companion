package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.PublicTransport.PublicTransportTravelDto;
import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleDto;
import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleResponse;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficDetail;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfoDto;
import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.PublicTransportSchedule;
import com.oc.p12.Entity.PublicTransportTraffic;
import com.oc.p12.Entity.PublicTransportTravel;
import com.oc.p12.Repository.PublicTransportScheduleRepository;
import com.oc.p12.Repository.PublicTransportTrafficRepository;
import com.oc.p12.Repository.PublicTransportTravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PublicTransportService {

    @Autowired
    PublicTransportTravelRepository publicTransportTravelRepository;

    @Autowired
    PublicTransportScheduleRepository publicTransportScheduleRepository;

    @Autowired
    PublicTransportTrafficRepository publicTransportTrafficRepository;

    private String publicTransportApiUrl = "https://api-ratp.pierre-grimaud.fr/v4";
    private RestTemplate restTemplate = new RestTemplate();

    public TrafficDetail savePublicTransportTraffic(PublicTransportTraffic publicTransportTraffic){
        return new TrafficDetail(publicTransportTraffic);
    }

    public PublicTransportScheduleDto savePublicTransportSchedule(PublicTransportSchedule publicTransportSchedule){
        return new PublicTransportScheduleDto(publicTransportScheduleRepository.save(publicTransportSchedule));
    }

    public PublicTransportTravelDto savePublicTransportTravel(PublicTransportTravel publicTransportTravelInfo){
        return new PublicTransportTravelDto(publicTransportTravelRepository.save(publicTransportTravelInfo));
    }

    public TrafficInfoDto getTrafficInformation(String transportType ,String line){

        ResponseEntity<TrafficInfoDto> trafficInfo = restTemplate.getForEntity(publicTransportApiUrl+"/traffic/"+transportType+"/"+line, TrafficInfoDto.class);
        return trafficInfo.getBody();
    }

    public PublicTransportScheduleResponse getTrafficSchedule(String transportType, String line, String station){
        ResponseEntity<PublicTransportScheduleResponse> trafficSchedule =  restTemplate.getForEntity(publicTransportApiUrl+"/schedules/"+transportType+"/"+line+"/"+station+"/A+R", PublicTransportScheduleResponse.class);
        return trafficSchedule.getBody();
    }

    public PublicTransportTravelDto getPublicTransportTravel(Account account){
        return new PublicTransportTravelDto(publicTransportTravelRepository.findByAccount(account));
    }




}
