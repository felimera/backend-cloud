package com.project.appcustomer.service;

import com.project.appcustomer.entity.Customer;
import com.project.appcustomer.entity.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> findCustomerAll();

    List<Customer> findCustomerByRegion(Region region);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    Customer deleteCustomer(Customer customer);

    Customer getCustomer(Long id);
}
