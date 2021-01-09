package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Entity.Address;
import com.oc.p12.Repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    AdressRepository adressRepository;

    public AdressDto saveToDto(Address address){
    return new AdressDto(adressRepository.save(address));
    }

    public Address save(Address address){
        return adressRepository.save(address);
    }
}
