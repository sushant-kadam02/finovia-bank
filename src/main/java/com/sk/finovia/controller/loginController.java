package com.sk.finovia.controller;

import com.sk.finovia.model.CustomResponse;
import com.sk.finovia.service.LoginService;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    LoginService loginService;

    JSONParser parser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);

    @PostMapping("/login")
    public ResponseEntity<?> validateLogin(@RequestBody String requestData) throws ParseException {
        JSONObject jsonObject = (JSONObject) parser.parse(requestData);
        CustomResponse response = loginService.ValidateLogin(jsonObject);
        return new ResponseEntity<>(response, response.getStatusCode());
    }

}
