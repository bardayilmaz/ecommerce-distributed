package com.example.ecommerceuser.repository.read;

import com.example.ecommerceuser.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFollowerRepository extends JpaRepository<Customer, Long> {
}
