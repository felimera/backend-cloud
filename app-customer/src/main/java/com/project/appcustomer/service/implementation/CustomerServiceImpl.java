package com.project.appcustomer.service.implementation;

import com.project.appcustomer.entity.Customer;
import com.project.appcustomer.entity.Region;
import com.project.appcustomer.repository.CustomerRepository;
import com.project.appcustomer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomerByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDb = customerRepository.findByNumberId(customer.getNumberId());
        if (Objects.nonNull(customerDb))
            return customerDb;

        customer.setState("CREATED");
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerDb = getCustomer(id);
        if (Objects.isNull(customerDb))
            return null;

        customerDb.setFirstName(customer.getFirstName());
        customerDb.setLastName(customer.getLastName());
        customerDb.setPhotoUrl(customer.getPhotoUrl());

        return customerRepository.save(customerDb);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerDb = getCustomer(customer.getId());
        if (Objects.isNull(customerDb))
            return null;

        customerDb.setState("DELETE");

        return customerRepository.save(customerDb);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
