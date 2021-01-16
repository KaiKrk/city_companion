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

@Service
@EnableScheduling
public class ScheduledService {

    private @Autowired WeatherService weatherService;
    private @Autowired AccountService accountService;
    private @Autowired PublicTransportService publicTransportService;
    private @Autowired EmailService emailService;


    @Scheduled(cron = "0 0 10 */2 * ?")// every 2 days at 10am
    public void fetchWeatherDatas(){
        weatherService.fetchWeatherDatas();
    }

    @Scheduled(cron = "0 */5 * ? * *")// cron every 5 minutes
    public void getPublicTransportTimelineForAccounts(){
        String time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,8);
        System.out.println(time);
/*        List<Account> accountByDepartureTime = accountService.getAccountByDepartureTime(time);
        List<PublicTransportTravel> publicTransportTravels = publicTransportService.getPublicTransportTravelsByAccountIn(accountByDepartureTime);*/
     //   List<Account> accounts = accountService.findAccountByListIdAccount(idAccounts);
    }

    @SneakyThrows
    @Scheduled(cron = "0 */1 * ? * *")// cron every minute
    public void sendDailyInformationsEmail(){
        String time = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0,8);
        System.out.println(time);
        List<Account> accounts  = accountService.getAccountByDepartureTime(time);
        if (!accounts.isEmpty()){
            for (Account account : accounts
            ) {
                emailService.sendEmailDailyInformations(account.getEmail(),account.getId());
            }
        }

    }

       

}
