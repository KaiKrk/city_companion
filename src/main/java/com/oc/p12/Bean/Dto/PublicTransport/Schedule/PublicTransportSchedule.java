package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

public class PublicTransportSchedule {

    public LineSchedule result;


    public PublicTransportSchedule(LineSchedule result) {
        this.result = result;
    }

    public PublicTransportSchedule() {
    }

    public LineSchedule getResult() {
        return result;
    }

    public void setResult(LineSchedule result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PublicTransportSchedule{" +
                "result=" + result +
                '}';
    }
}
