package com.sk.finovia.service;

import com.sk.finovia.model.CustomResponse;
import com.sk.finovia.model.Customer;
import com.sk.finovia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    ResponseGenerator responseGenerator;

    @Autowired
    MongoTemplate mongoTemplate;

    public CustomResponse registerNewCustomer(Customer customer) {
        CustomResponse response = new CustomResponse();
        String email = customer.getEmail();
        String userName = customer.getUserName();
        Query query = new Query();

        query.addCriteria(new Criteria().orOperator(
                Criteria.where("userName").is(userName),
                Criteria.where("email").is(email)));
        Customer cust = mongoTemplate.find(query, Customer.class).size() > 0
                ? mongoTemplate.find(query, Customer.class).get(0)
                : null;
        if (null != cust) {
            return new CustomResponse(false, "User or email already exists", null, HttpStatus.IM_USED);
        }

        mongoTemplate.save(customer);
        response = responseGenerator.positiveResponse(customer, "User registered successfully.");
        return response;
    }


}
