package com.oc.p12.Service;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Repository.TransportInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportInfoService {

    @Autowired
    TransportInfoRepository transportInfoRepository;

    public TransportInfo save(TransportInfo transportInfo){
        return transportInfoRepository.save(transportInfo);
    }

    public TransportInfo findByAccount(Account account){
        return transportInfoRepository.findByAccount(account);
    }

}
