package com.example.ecommerceuser.controller;

import com.example.ecommerceuser.model.request.CustomerRequest;
import com.example.ecommerceuser.model.response.CustomerResponse;
import com.example.ecommerceuser.service.CustomerService;
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

    @GetMapping("/{id}")
    public CustomerResponse getCustomers(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
}
