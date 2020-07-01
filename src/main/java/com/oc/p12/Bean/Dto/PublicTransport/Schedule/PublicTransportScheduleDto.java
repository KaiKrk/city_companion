package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

public class PublicTransportScheduleDto {

    public LineSchedule result;


    public PublicTransportScheduleDto(LineSchedule result) {
        this.result = result;
    }

    public PublicTransportScheduleDto() {
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
