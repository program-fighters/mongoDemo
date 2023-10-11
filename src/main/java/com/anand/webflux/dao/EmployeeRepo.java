package com.anand.webflux.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.anand.webflux.model.EmployeeDTO;

@Repository
public interface EmployeeRepo extends MongoRepository<EmployeeDTO, Integer> {

}
