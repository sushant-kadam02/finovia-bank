package com.sk.finovia.service;

import com.sk.finovia.model.CustomResponse;
import com.sk.finovia.model.Customer;
import com.sk.finovia.repository.CustomerRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    CustomerRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    public CustomResponse ValidateLogin(JSONObject jsonObject) {
        CustomResponse response = new CustomResponse();
        String userName = (String) jsonObject.get("userName");
        String password = (String) jsonObject.get("password");
        boolean flag = Boolean.FALSE;
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName).and("password").is(password));

        List<Customer> customerList = mongoTemplate.find(query, Customer.class);
        Customer customer = customerList.size() > 0 ? customerList.get(0) : null;
        if(customer != null) {
            flag = Boolean.TRUE;
            response.setMessage("Welcome "+ userName +", login successful.");
            response.setStatusCode(HttpStatus.OK);
            response.setData(customer);
        } else {
            response.setMessage("login failed.");
            response.setStatusCode(HttpStatus.FORBIDDEN);
        }

        response.setSuccess(flag);


        return response;
    }
}
