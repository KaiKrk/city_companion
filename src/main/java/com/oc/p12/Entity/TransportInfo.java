package com.oc.p12.Entity;

import com.oc.p12.Bean.Dto.TransportRegistrationDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table(name = "transport_info")
public class TransportInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_info_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id" )
    private Account account;

    @Column(name = "transport_type")
    private String transportType;

    @Column(name = "transport_line")
    private String transportLine;

    @Column(name = "departure_stop")
    private String departureStop;

    public TransportInfo() {
    }

    public TransportInfo(TransportRegistrationDto dto) {
        this.transportType = dto.getTransport();
        this.transportLine = dto.getTransportLine();
        this.departureStop = dto.getDepartureStop();
    }

    public TransportInfo(TransportRegistrationDto dto, Account account) {
        this.transportType = dto.getTransport();
        this.transportLine = dto.getTransportLine();
        this.departureStop = dto.getDepartureStop();
        this.account = account;
    }

    public TransportInfo(Account account, Adress workAdress){
        this.account = account;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
