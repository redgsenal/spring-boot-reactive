package com.springboot.reactive.dao;

import lombok.Data;

@Data
public class StudentRequest {

    private String firstname;
    private String lastname;
    private int age;

}