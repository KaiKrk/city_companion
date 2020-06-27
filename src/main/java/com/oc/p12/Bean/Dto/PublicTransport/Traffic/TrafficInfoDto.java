package com.oc.p12.Bean.Dto.PublicTransport.Traffic;

import java.util.List;

public class TrafficInfoDto {

    private TrafficDetail result;

    public TrafficInfoDto() {
    }

    public TrafficDetail getResult() {
        return result;
    }

    public void setResult(TrafficDetail result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TrafficInfoDto{" +
                "result=" + result +
                '}';
    }
}
