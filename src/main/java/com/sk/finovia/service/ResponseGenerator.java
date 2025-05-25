package com.sk.finovia.service;

import com.sk.finovia.model.CustomResponse;
import com.sk.finovia.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ResponseGenerator {
    public CustomResponse positiveResponse(Customer customer, String msg) {
        CustomResponse response = new CustomResponse();
        response.setSuccess(Boolean.TRUE);
        response.setMessage(msg);
        response.setData(customer);
        response.setStatusCode(HttpStatus.OK);
        return response;
    }

    public CustomResponse customizedResponse(boolean successFlag, Customer customer, String msg, HttpStatus status) {
        CustomResponse response = new CustomResponse();
        response.setSuccess(successFlag);
        response.setMessage(msg);
        response.setData(customer);
        response.setStatusCode(status);
        return response;
    }

}
