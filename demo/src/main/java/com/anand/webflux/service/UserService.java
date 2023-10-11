package com.anand.webflux.service;

import com.anand.webflux.dao.EmployeeRepo;
import com.anand.webflux.model.EmpResponse;
import com.anand.webflux.model.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anand.webflux.dao.UserRepo;
import com.anand.webflux.model.UserDTO;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    public void saveUser(UserDTO dto) {
        userRepo.save(dto);
    }

    public Object findAllEmpAndUserId() {
        List<EmpResponse> empResponses = new ArrayList<>();
        List<EmployeeDTO> employeeDTOS = employeeRepo.findAll();
        List<UserDTO> userDTOS = userRepo.findAll();
        log.info("users::{}", userDTOS);
        if (!ObjectUtils.isEmpty(employeeDTOS)) {
            for (EmployeeDTO e : employeeDTOS) {
                Optional<UserDTO> us = userDTOS.stream().filter(u -> u.getFirstName().equals(e.getName())).findAny();
                empResponses.add(new EmpResponse(e.getId(), e.getName(), us.map(UserDTO::getEmailAddress).orElse(null)));
            }
        }
        return empResponses;
    }
}
