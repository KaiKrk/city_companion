package com.oc.p12.Bean.Dto.Dashboard;

import com.oc.p12.Entity.AirQuality;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AirQualityDashboardDto {

    public String index;
    public String quality;
    public String pm25;
    public String pm10;
    public String o3;

    public AirQualityDashboardDto(AirQuality airQuality) {
        this.index = String.valueOf(airQuality.getEpaAqi());
        this.quality =  String.valueOf(airQuality.getEpaHealthConcernMessage());
        this.pm25 =  String.valueOf(airQuality.getPm25());
        this.pm10 =  String.valueOf(airQuality.getPm10());
        this.o3 = String.valueOf(airQuality.getO3());
    }
}
