package com.oc.p12.Bean.Dto.PublicTransport.Schedule;

public class PublicTransportInformationDto {

    public LineSchedule result;


    public PublicTransportInformationDto(LineSchedule result) {
        this.result = result;
    }

    public PublicTransportInformationDto() {
    }

    public LineSchedule getResult() {
        return result;
    }

    public void setResult(LineSchedule result) {
        this.result = result;
    }
}
