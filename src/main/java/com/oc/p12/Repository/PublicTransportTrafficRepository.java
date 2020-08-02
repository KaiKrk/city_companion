package com.oc.p12.Repository;

import com.oc.p12.Bean.Dto.PublicTransport.Traffic.TrafficInfo;
import com.oc.p12.Entity.PublicTransportTraffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublicTransportTrafficRepository extends JpaRepository<PublicTransportTraffic, Integer> {

    @Query(
            value = "SELECT * from public_transport_traffic where line = ?1 and registered_on = (SELECT MAX(registered_on) FROM public_transport_traffic)",
            nativeQuery = true)
    public TrafficInfo findLatestRecordByLine(String line);


}
