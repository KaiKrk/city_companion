package com.oc.p12.Bean.Dto.PublicTransport.Traffic;

public class TrafficInfoResponse {

    private TrafficInfo result;

    public TrafficInfoResponse() {
    }

    public TrafficInfo getResult() {
        return result;
    }

    public void setResult(TrafficInfo result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TrafficInfoDto{" +
                "result=" + result +
                '}';
    }
}
