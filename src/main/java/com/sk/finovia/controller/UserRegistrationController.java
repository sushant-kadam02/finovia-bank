package com.sk.finovia.controller;

import com.sk.finovia.model.CustomResponse;
import com.sk.finovia.model.Customer;
import com.sk.finovia.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody Customer customer) {
        CustomResponse customer1 = userRegistrationService.registerNewCustomer(customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }



}
