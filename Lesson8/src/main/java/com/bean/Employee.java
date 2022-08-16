package com.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
public class Employee {
    @Id
    private int id;
    private String name;
    private float salary;
}
