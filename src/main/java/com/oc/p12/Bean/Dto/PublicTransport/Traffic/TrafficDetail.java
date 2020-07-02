package com.oc.p12.Bean.Dto.PublicTransport.Traffic;

import com.oc.p12.Entity.PublicTransportTraffic;

public class TrafficDetail {

    private String line;

    private String title;

    private String message;

    public TrafficDetail(PublicTransportTraffic publicTransportTraffic) {
        this.line = publicTransportTraffic.getLine();
        this.title = publicTransportTraffic.getTitle();
        this.message = publicTransportTraffic.getMessage();
    }

    public TrafficDetail() {
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TrafficDetail{" +
                "line='" + line + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
