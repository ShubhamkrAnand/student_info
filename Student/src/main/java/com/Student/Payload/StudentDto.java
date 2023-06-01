package com.Student.Payload;

import lombok.Data;



@Data
public class StudentDto {
    private long id;
    private String name;
    private int className ;
    private  int age;
    private String email;
}
