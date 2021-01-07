package com.oc.p12.Bean.Dto;

import com.oc.p12.Entity.PublicTransportTravel;
import com.oc.p12.Entity.TransportInfo;
import sun.rmi.transport.Transport;

public class TransportRegistrationDto {
    public int id;
    public String transport;
    public String transportLine;
    public String departureStop;

    public TransportRegistrationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransportRegistrationDto(TransportInfo transport) {
        this.id = transport.getId();
        this.transport =  transport.getTransportType();
        this.transportLine = transport.getTransportLine();
        this.departureStop = transport.getDepartureStop();

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
                "id=" + id +
                ", transport='" + transport + '\'' +
                ", transportLine='" + transportLine + '\'' +
                ", departureStop='" + departureStop + '\'' +
                '}';
    }
}
