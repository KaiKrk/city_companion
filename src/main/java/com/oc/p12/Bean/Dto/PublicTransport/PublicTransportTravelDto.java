package com.oc.p12.Bean.Dto.PublicTransport;

import com.oc.p12.Entity.PublicTransportTraffic;
import com.oc.p12.Entity.PublicTransportTravel;

public class PublicTransportTravelDto {

    private int id;

    private String station;

    private String line;

    public PublicTransportTravelDto(PublicTransportTravel publicTransportTravel) {
        this.id = publicTransportTravel.getId();
        this.station =  publicTransportTravel.getStation();
        this.line =  publicTransportTravel.getTransportLine();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
