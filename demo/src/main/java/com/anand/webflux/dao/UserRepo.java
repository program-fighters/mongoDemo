package com.anand.webflux.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anand.webflux.model.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Integer>{

}
