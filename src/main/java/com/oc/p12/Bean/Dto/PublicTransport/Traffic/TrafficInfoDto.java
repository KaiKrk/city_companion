package com.oc.p12.Bean.Dto.PublicTransport.Traffic;

import java.util.List;

public class TrafficInfoDto {

    List<TrafficDetail> result;

    public TrafficInfoDto() {
    }

    public List<TrafficDetail> getResult() {
        return result;
    }

    public void setResult(List<TrafficDetail> result) {
        this.result = result;
    }
}
