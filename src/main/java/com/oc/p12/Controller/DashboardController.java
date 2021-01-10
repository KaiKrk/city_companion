package com.oc.p12.Controller;

import com.oc.p12.Bean.Dto.Dashboard.GeneralDashboardInformation;
import com.oc.p12.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/dashboard")
    public ResponseEntity<GeneralDashboardInformation> getAccountInfo(@RequestParam Integer id){
        GeneralDashboardInformation dto = dashboardService.getDashboardInformations(id);
        System.out.println(dto.toString());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    
}
