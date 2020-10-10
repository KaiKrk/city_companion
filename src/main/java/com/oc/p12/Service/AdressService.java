package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    AdressRepository adressRepository;

    public AdressDto saveToDto(Adress adress){
    return new AdressDto(adressRepository.save(adress));
    }

    public Adress save(Adress adress){
        return adressRepository.save(adress);
    }
}
