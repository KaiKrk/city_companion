package com.oc.p12.Service;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.PublicTransportTravel;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * scheduled service
 */
@Service
@EnableScheduling
public class ScheduledService {

    private @Autowired WeatherService weatherService;
    private @Autowired AccountService accountService;
    private @Autowired PublicTransportService publicTransportService;
    private @Autowired EmailService emailService;

    /**
     * schedule method to start weatcher data fetch
     */
    @Scheduled(cron = "0 0 10 */2 * ?")// every 2 days at 10am
    public void fetchWeatherDatas(){
        weatherService.fetchWeatherDatas();
    }


    @Scheduled(cron = "0 */5 * ? * *")// cron every 5 minutes
        public void getPublicTransportTimelineForAccounts(){
            String time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,8);
    }

    /**
     * method that retrieve every minutes account that have departure time soon to inform them about weather and transport/traffic status
     */
    @SneakyThrows
    @Scheduled(cron = "0 */1 * ? * *")// cron every minute
    public void sendDailyInformationsEmail(){
        String time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,5);
        System.out.println(time);
        List<Account> accounts  = accountService.getAccountByDepartureTime(time);
        System.out.println("accounts " + accounts);
        if (!accounts.isEmpty()){
            for (Account account : accounts
            ) {
                emailService.sendEmailDailyInformations(account.getEmail(),account.getId());
            }
        }

    }

       

}
