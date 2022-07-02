package com.istidataproject.service;


import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istidataproject.entity.Information;
import com.istidataproject.repo.InformationRepo;




@Service
@Transactional
public class DataInformation {

      @Autowired
      private InformationRepo repo;

    public Iterable<Information>findAll(){
        return repo.findAll();
    }

    public void saveInformation(Information information){
      repo.save(information);
    }

    public void deleteByNik(long nik){
      repo.deleteById(nik);
    }

    public Optional<Information> findByNik(long nik){
      return repo.findById(nik);
    }

    public void updateInformation(Information information){
      repo.save(information);
    }

    public List<Information> findByName(String keyword){
        return repo.findByNameContains(keyword);
    }

}
