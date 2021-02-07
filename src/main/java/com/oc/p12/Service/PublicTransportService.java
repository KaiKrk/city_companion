package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Dashboard.PublicTransportDashboardDTO;
import com.oc.p12.Bean.Dto.PublicTransport.PublicTransportTravelDto;
import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleDto;
import com.oc.p12.Bean.Dto.PublicTransport.Schedule.PublicTransportScheduleResponse;
import com.oc.p12.Bean.Dto.PublicTransport.Stations.PublicTransportStationsResponse;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfo;
import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfoResponse;
import com.oc.p12.Entity.*;
import com.oc.p12.Repository.PublicTransportScheduleRepository;
import com.oc.p12.Repository.PublicTransportTrafficRepository;
import com.oc.p12.Repository.PublicTransportTravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Service to fetch and return datas from RATP API
 *
 */
@Service
public class PublicTransportService {

    @Autowired
    PublicTransportTravelRepository publicTransportTravelRepository;

    @Autowired
    TransportInfoService transportInfoService;

    @Autowired
    PublicTransportScheduleRepository publicTransportScheduleRepository;

    @Autowired
    PublicTransportTrafficRepository publicTransportTrafficRepository;

    @Autowired
    AccountService accountService;
    /**
     * initiate API url
     */
    private String publicTransportApiUrl = "https://api-ratp.pierre-grimaud.fr/v4";
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * save public transport traffic informations
     * @param publicTransportTraffic
     * @return TrafficInfo
     */
    public TrafficInfo savePublicTransportTraffic(PublicTransportTraffic publicTransportTraffic){
        return new TrafficInfo(publicTransportTrafficRepository.save(publicTransportTraffic));
    }

    public PublicTransportScheduleDto savePublicTransportSchedule(PublicTransportSchedule publicTransportSchedule){
        return new PublicTransportScheduleDto(publicTransportScheduleRepository.save(publicTransportSchedule));
    }

    public PublicTransportTravelDto savePublicTransportTravel(PublicTransportTravel publicTransportTravelInfo){
        return new PublicTransportTravelDto(publicTransportTravelRepository.save(publicTransportTravelInfo));
    }

    /**
     * fetch real time traffic status from RATP API
     * @param transportType
     * @param line
     * @return return API json response in a dto
     */
    public TrafficInfoResponse fetchTrafficInformation(String transportType , String line){

        ResponseEntity<TrafficInfoResponse> trafficInfo = restTemplate.getForEntity(publicTransportApiUrl+"/traffic/"+transportType+"/"+line, TrafficInfoResponse.class);
        savePublicTransportTraffic(new PublicTransportTraffic(trafficInfo.getBody().getResult()));
        return trafficInfo.getBody();
    }

    /**
     * get all station for a line
     * @param transportType
     * @param line
     * @return
     */
    public PublicTransportStationsResponse getLineStations(String transportType , String line){

        ResponseEntity<PublicTransportStationsResponse> trafficInfo = restTemplate.getForEntity(publicTransportApiUrl+"/stations/"+transportType+"/"+line, PublicTransportStationsResponse.class);
        return trafficInfo.getBody();
    }

    /**
     * Get from RATP API the specific traffic status from a station
     * @param transportType
     * @param line
     * @param station
     * @return API json response in a DTO
     */
    public PublicTransportScheduleResponse fetchTrafficSchedule(String transportType, String line, String station){
        ResponseEntity<PublicTransportScheduleResponse> trafficSchedule =  restTemplate.getForEntity(publicTransportApiUrl+"/schedules/"+transportType+"/"+line+"/"+station+"/A+R", PublicTransportScheduleResponse.class);
        return trafficSchedule.getBody();
    }


    /**
     * get transport info for dashboard display for an account
     * @param accountId
     * @return
     */
    public PublicTransportDashboardDTO getPublicTransportDashboardInfo(int accountId){
        Account account = accountService.findById(accountId);
        TransportInfo tf = transportInfoService.findByAccount(account);
        if (tf.getTransportType().equals("car")){
            return new PublicTransportDashboardDTO();
        } else {
            PublicTransportScheduleResponse publicTransportScheduleResponse = fetchTrafficSchedule(tf.getTransportType(),tf.getTransportLine(),tf.getDepartureStop());
            TrafficInfoResponse trafficInfoResponse = fetchTrafficInformation(tf.getTransportType(),tf.getTransportLine());
            return new PublicTransportDashboardDTO(tf.getTransportType(),tf.getTransportLine(),tf,publicTransportScheduleResponse,trafficInfoResponse);
        }

    }



}
