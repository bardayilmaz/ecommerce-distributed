package com.example.ecommercemongodb.controller;

import com.example.ecommercemongodb.model.request.CustomerRequest;
import com.example.ecommercemongodb.model.response.CustomerResponse;
import com.example.ecommercemongodb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public CustomerResponse addCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.addCustomer(customerRequest);
    }
}
