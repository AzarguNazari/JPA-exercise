package com.example.jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee {

    @EmbeddedId
    private EmployeeIdentity employeeIdentity;

    private String name;

    @NaturalId
    private String email;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    public Employee(EmployeeIdentity employeeIdentity, String name, String email, String phoneNumber) {
        this.employeeIdentity = employeeIdentity;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
