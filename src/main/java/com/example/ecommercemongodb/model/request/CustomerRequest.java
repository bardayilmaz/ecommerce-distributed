package com.example.ecommercemongodb.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerRequest {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String address;
}
