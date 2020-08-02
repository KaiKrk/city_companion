package com.oc.p12.Entity;

import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfo;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "public_transport_traffic")
@ToString
public class PublicTransportTraffic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "public_transport_traffic_id")
    private int id;

    @Column(name = "line")
    private String line;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "registered_on")
    private LocalDateTime registerOn;

    public PublicTransportTraffic() {
    }

    public PublicTransportTraffic(TrafficInfo trafficInfo){
        this.line = trafficInfo.getLine();
        this.message = trafficInfo.getMessage();
        this.title = trafficInfo.getTitle();
        this.registerOn = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
