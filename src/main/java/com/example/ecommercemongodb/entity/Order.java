package com.example.ecommercemongodb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "order_date")
    private LocalDateTime orderDate;
}
