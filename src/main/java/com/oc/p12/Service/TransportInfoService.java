package com.oc.p12.Service;

import com.oc.p12.Entity.Account;
import com.oc.p12.Entity.TransportInfo;
import com.oc.p12.Repository.TransportInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service for transport informations entity
 */
@Service
public class TransportInfoService {

    @Autowired
    TransportInfoRepository transportInfoRepository;

    /**
     * save account's transport informations
     * @param transportInfo
     * @return
     */
    public TransportInfo save(TransportInfo transportInfo){
        return transportInfoRepository.save(transportInfo);
    }

    /**
     * get the transport informations by account
     * @param account
     * @return
     */
    public TransportInfo findByAccount(Account account){
        return transportInfoRepository.findByAccount(account);
    }

}
