package com.sk.finovia.service;

import com.sk.finovia.model.CustomResponse;
import org.springframework.stereotype.Service;

@Service
public class ResponseGenerator {
// TODO: no use currently
    public CustomResponse positiveResponse() {

        return new CustomResponse();
    }

}
