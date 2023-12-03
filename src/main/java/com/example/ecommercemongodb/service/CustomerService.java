package com.example.ecommercemongodb.service;

import com.example.ecommercemongodb.entity.Customer;
import com.example.ecommercemongodb.model.request.CustomerRequest;
import com.example.ecommercemongodb.model.response.CustomerResponse;
import com.example.ecommercemongodb.repository.read.CustomerFollowerRepository;
import com.example.ecommercemongodb.repository.write.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerFollowerRepository customerFollowerRepository;
    private final CustomerRepository customerRepository;

    public List<CustomerResponse> getCustomers() {
        return customerFollowerRepository.findAll().stream().map(CustomerResponse::fromEntity).collect(Collectors.toList());
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setAddress(customerRequest.getAddress());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customerRepository.save(customer);
        return CustomerResponse.fromEntity(customer);
    }
}
