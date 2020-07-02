package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

import com.oc.p12.Entity.PublicTransportSchedule;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class PublicTransportScheduleDto {

    private LocalDateTime registerOn;

    private String nextTransportIn;

    private String line;

    private String station;

    private String direction;

    public PublicTransportScheduleDto(PublicTransportSchedule publicTransportSchedule) {

        this.registerOn = publicTransportSchedule.getRegisterOn();
        this.nextTransportIn = publicTransportSchedule.getNextTransportIn();
        this.line = publicTransportSchedule.getLine();
        this.station = publicTransportSchedule.getStation();
        this.direction = publicTransportSchedule.getDirection();
    }

    public PublicTransportScheduleDto() {
    }

    public LocalDateTime getRegisterOn() {
        return registerOn;
    }

    public void setRegisterOn(LocalDateTime registerOn) {
        this.registerOn = registerOn;
    }

    public String getNextTransportIn() {
        return nextTransportIn;
    }

    public void setNextTransportIn(String nextTransportIn) {
        this.nextTransportIn = nextTransportIn;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
