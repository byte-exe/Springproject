package com.istidataproject.repo;

import org.springframework.data.repository.CrudRepository;

import com.istidataproject.entity.Information;

import java.util.List;

public interface InformationRepo extends CrudRepository<Information, Long>{
    
    List<Information> findByNameContains(String keyword);

}
