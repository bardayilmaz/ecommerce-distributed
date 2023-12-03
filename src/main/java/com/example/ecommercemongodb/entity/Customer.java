package com.example.ecommercemongodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "lastname_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;


}
