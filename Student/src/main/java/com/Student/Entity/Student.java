package com.Student.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Student_Inform")
public class Student {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 @Column(name="Name",nullable = false)
    private String name;
 @Column(name="Class_Name",nullable = false)
    private int className; ;
 @Column(name="Age",nullable = false)
    private  int age;
 @Column(name="Email",nullable = false)
    private String email;


}
