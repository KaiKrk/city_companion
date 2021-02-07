package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Dashboard.GeneralDashboardInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * service for city companion dashboard display
 */
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

    /**
     * dashbaord method that goes an fetch all datas from services for it to be displayed on dashboard
     * @param accountId
     * @return GenralDashboardInformation
     */
    public GeneralDashboardInformation getDashboardInformations(int accountId){
        GeneralDashboardInformation generalDashboardInformation = new GeneralDashboardInformation();
        generalDashboardInformation.setWeather(weatherService.getWeatherDashboardInfo());
        generalDashboardInformation.setAirQuality(weatherService.getAirQualityDashboardInfo());
        generalDashboardInformation.setCarTraffic(carTravelService.getTrafficDashboardDTO(accountId));

        generalDashboardInformation.setDate(LocalDate.now().toString().concat(" ").concat(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString()));
        generalDashboardInformation.setPublicTransport(publicTransportService.getPublicTransportDashboardInfo(accountId));
        return generalDashboardInformation;
    }

}
