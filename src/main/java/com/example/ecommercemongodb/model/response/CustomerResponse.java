package com.example.ecommercemongodb.model.response;

import com.example.ecommercemongodb.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerResponse {

    private String firstName;

    private String lastName;

    private String address;

    public static CustomerResponse fromEntity(Customer customer) {
        return CustomerResponse.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(customer.getAddress())
                .build();
    }
}
