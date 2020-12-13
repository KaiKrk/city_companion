package com.oc.p12.Bean.Dto;

import com.oc.p12.Entity.PublicTransportTravel;

public class TransportRegistrationDto {
    public String transport;
    public String transportLine;
    public String departureStop;

    public TransportRegistrationDto(PublicTransportTravel transport) {
        this.transport =  transport.getTransportType().toString();
        this.transportLine = transport.getTransportLine();
        this.departureStop = transport.getStation();

    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTransportLine() {
        return transportLine;
    }

    public void setTransportLine(String transportLine) {
        this.transportLine = transportLine;
    }

    public String getDepartureStop() {
        return departureStop;
    }

    public void setDepartureStop(String departureStop) {
        this.departureStop = departureStop;
    }

    @Override
    public String toString() {
        return "TransportRegistrationDto{" +
                "transport='" + transport + '\'' +
                ", transportLine='" + transportLine + '\'' +
                ", departureStop='" + departureStop + '\'' +
                '}';
    }
}
