package com.sk.finovia.service;

import com.sk.finovia.model.Customer;
import com.sk.finovia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Customer registerNewCustomer(Customer customer) {
        return mongoTemplate.save(customer);
    }


}
