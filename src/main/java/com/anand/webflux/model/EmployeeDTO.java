package com.anand.webflux.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@Document(value = "employee_details")
@Getter
@Setter
public class EmployeeDTO {

    @Id
    private  String id = UUID.randomUUID().toString();

    private String name;

    private long salary;

    private MultipartFile video;




    @Override
    public String toString() {
        return super.toString();
    }

}
