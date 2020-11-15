package com.oc.p12.Bean.Dto.PublicTransport.Stations;

import com.oc.p12.Bean.Dto.PublicTransport.Schedule.LineSchedule;

public class PublicTransportStationsResponse {

    public LineStops result;


    public PublicTransportStationsResponse(LineStops result) {
        this.result = result;
    }

    public PublicTransportStationsResponse() {
    }

    public LineStops getResult() {
        return result;
    }
    public void setResult(LineStops result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PublicTransportSchedule{" +
                "result=" + result +
                '}';
    }
}
