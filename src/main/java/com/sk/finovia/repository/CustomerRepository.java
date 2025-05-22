package com.sk.finovia.repository;

import com.sk.finovia.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

    Customer findByUserNameAndPassword(String Name, String password);

}
