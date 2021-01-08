package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.CarTraffic.CarTrafficDashboardDTO;
import com.oc.p12.Bean.Dto.GeneralDashboardInformation;
import com.oc.p12.Entity.Account;
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
        Account account = accountService.findById(accountId);
        GeneralDashboardInformation generalDashboardInformation = new GeneralDashboardInformation();

        return null;
    }

}
