package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

public class ScheduleDetail {

    private String message;

    private String destination;

    public ScheduleDetail() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "SchduleDetail{" +
                "message='" + message + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
