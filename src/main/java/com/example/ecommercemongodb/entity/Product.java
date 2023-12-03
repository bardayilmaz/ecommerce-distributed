package com.example.ecommercemongodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;
}
