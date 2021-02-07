package com.oc.p12.Service;

import com.oc.p12.Bean.Dto.Adress.AdressDto;
import com.oc.p12.Entity.Adress;
import com.oc.p12.Repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service for adress entity
 */
@Service
public class AdressService {

    @Autowired
    AdressRepository adressRepository;

    /**
     * save adress and return dto
     * @param address
     * @return adressDTO
     */
    public AdressDto saveToDto(Adress address){
    return new AdressDto(adressRepository.save(address));
    }

    /**
     * find adress by id
     * @param id
     * @return adress
     */
    public Adress findById(int id){
        return adressRepository.findById(id);
    }

    /**
     * save adress and return the entity
     * @param adress
     * @return adress
     */
    public Adress save(Adress adress){
        return adressRepository.save(adress);
    }

    /**
     * delete adress by it's id
     * @param id
     */
    public void delete(int id){
        adressRepository.delete(findById(id));
    }
}
