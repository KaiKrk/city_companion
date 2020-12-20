package com.oc.p12.Repository;

import com.oc.p12.Entity.TransportInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportInfoRepository  extends JpaRepository<TransportInfo, Integer> {

}
