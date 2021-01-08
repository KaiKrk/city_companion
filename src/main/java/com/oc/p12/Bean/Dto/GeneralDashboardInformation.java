package com.oc.p12.Bean.Dto;

import com.oc.p12.Bean.Dto.CarTraffic.CarTrafficDashboardDTO;
import com.oc.p12.Bean.Dto.Dashboard.AirQualityDashboardDto;
import com.oc.p12.Bean.Dto.Dashboard.PublicTransportDashboardDTO;
import com.oc.p12.Bean.Dto.Dashboard.WeatherDashboardDto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GeneralDashboardInformation {

    WeatherDashboardDto weather;
    AirQualityDashboardDto airQuality;
    PublicTransportDashboardDTO publicTransport;
    CarTrafficDashboardDTO carTraffic;

}
