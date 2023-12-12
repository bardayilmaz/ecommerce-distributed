package com.example.ecommerceuser.service;

import com.example.ecommerceuser.entity.Customer;
import com.example.ecommerceuser.model.request.CustomerRequest;
import com.example.ecommerceuser.model.response.CustomerResponse;
import com.example.ecommerceuser.repository.read.CustomerFollowerRepository;
import com.example.ecommerceuser.repository.write.CustomerRepository;
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

    public CustomerResponse getCustomer(Long id) {
        return customerFollowerRepository.findById(id).map(CustomerResponse::fromEntity).orElseThrow(() -> new RuntimeException("Error"));
    }
}
