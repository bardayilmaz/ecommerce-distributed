package com.example.ecommercemongodb.repository.read;

import com.example.ecommercemongodb.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerFollowerRepository extends JpaRepository<Customer, String> {

//    @Query(value = "error", nativeQuery = true)
//    Customer save(Customer customer);
}
