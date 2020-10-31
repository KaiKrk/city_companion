package com.oc.p12.Bean.Dto.CarTraffic;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CarTravelResponseDto {

    private List<String> originAddresses;

    private List<String> destinationAddresses;

    private List<DistanceInformationDto> rows;

    private String status;

    public CarTravelResponseDto() {
    }


    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public List<DistanceInformationDto> getRows() {
        return rows;
    }

    public void setRows(List<DistanceInformationDto> rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CarTravelDto{" +
                "originAdress=" + originAddresses +
                ", destinationAdress=" + destinationAddresses +
                ", rows=" + rows +
                ", status='" + status + '\'' +
                '}';
    }

    public String normalTrafficTime(){
        return rows.get(0).getElements().get(0).getDuration().getText();
    }

    public String realTrafficTime(){
        return rows.get(0).getElements().get(0).getDurationInTraffic().getText();
    }

    public String distanceAtoB(){
        return rows.get(0).getElements().get(0).getDistance().getText();
    }
}
