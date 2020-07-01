package com.oc.p12.Entity;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "public_transport_schedule")
@ToString
public class PublicTransportSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "public_transport_schedule_id")
    private int id;

    @Column(name = "registered_on")
    private LocalDateTime registerOn;

    @Column(name = "next_transport_in")
    private String nextTransportIn;

    @Column(name = "line")
    private String line;

    @Column(name = "station")
    private String station;

    @Column(name = "direction")
    private String direction;

    public PublicTransportSchedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
