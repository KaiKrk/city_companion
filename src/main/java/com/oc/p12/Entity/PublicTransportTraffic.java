package com.oc.p12.Entity;

import lombok.ToString;

import javax.persistence.*;

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

    public PublicTransportTraffic() {
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
