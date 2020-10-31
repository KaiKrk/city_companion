package com.oc.p12.Service;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.PublicTransportTravel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@EnableScheduling
public class ScheduledService {

    private @Autowired WeatherService weatherService;
    private @Autowired AccountService accountService;
    private @Autowired PublicTransportService publicTransportService;


    @Scheduled(cron = "0 0 1 */2 * ?")
    public void fetchWeatherDatas(){
        weatherService.fetchWeatherDatas();
    }

    @Scheduled(cron = "0 */5 * ? * *")
    public void getPublicTransportTimelineForAccounts(){
        String time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,8);
        List<Account> accountByDepartureTime = accountService.getAccountByDepartureTime(time);
        List<PublicTransportTravel> publicTransportTravels = publicTransportService.getPublicTransportTravelsByAccountIn(accountByDepartureTime);
     //   List<Account> accounts = accountService.findAccountByListIdAccount(idAccounts);
    }

       

}
