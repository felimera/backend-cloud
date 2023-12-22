package com.project.appcustomer.repository;

import com.project.appcustomer.entity.Customer;
import com.project.appcustomer.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNumberId(String numberId);

    List<Customer> findByLastName(String lastName);

    List<Customer> findByRegion(Region region);
}
