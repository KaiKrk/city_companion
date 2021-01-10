package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Dashboard.GeneralDashboardInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    AccountService accountService;

    @Autowired
    CarTravelService carTravelService;

    @Autowired
    WeatherService weatherService;

    @Autowired
    PublicTransportService publicTransportService;

    public GeneralDashboardInformation getDashboardInformations(int accountId){
        GeneralDashboardInformation generalDashboardInformation = new GeneralDashboardInformation();
        generalDashboardInformation.setWeather(weatherService.getWeatherDashboardInfo());
        generalDashboardInformation.setAirQuality(weatherService.getAirQualityDashboardInfo());
        generalDashboardInformation.setCarTraffic(carTravelService.getTrafficDashboardDTO(accountId));

        generalDashboardInformation.setPublicTransport(publicTransportService.getPublicTransportDashboardInfo(accountId));
        return generalDashboardInformation;
    }

}
