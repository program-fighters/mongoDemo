package com.anand.webflux.controller;

import javax.validation.Valid;

import com.anand.webflux.model.EmpResponse;
import com.anand.webflux.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anand.webflux.model.EmployeeDTO;
import com.anand.webflux.model.UserDTO;
import com.anand.webflux.service.EmployeeService;
import com.anand.webflux.service.UserService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController

public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/demo/saveEmployee")
    public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDTO emp) {
        try {
            employeeService.saveEmployee(emp);
            log.info("Device details saved successfully in Mongo DB!!!");
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
        }
        log.info("emp after commit.{}", emp);
        return ResponseEntity.ok(Response.builder()
                .data(emp)
                .message("created")
                .status("201")
                .build());

    }

    @PostMapping("/demo/saveUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO user) {
        userService.saveUser(user);
        log.info("Device details saved successfully in Postgres DB!!!");
        log.info("user after commit.{}", user);
        return ResponseEntity.ok(Response.builder()
                .data(user)
                .message("created")
                .status("201")
                .build());

    }

    @GetMapping(value = "/demo/test")
    public ResponseEntity<?> test() {
        log.info("test API");
        return ResponseEntity.ok("Server is running");
    }

    @GetMapping(value = "/demo/list")
    public ResponseEntity<?> list() {
        log.info("test API");
        return ResponseEntity.ok(Response.builder()
                .data(userService.findAllEmpAndUserId())
                .message("Data fetched.")
                .status("200")
                .build());
    }
}
