package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

public class PublicTransportScheduleResponse {

    public LineSchedule result;


    public PublicTransportScheduleResponse(LineSchedule result) {
        this.result = result;
    }

    public PublicTransportScheduleResponse() {
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
