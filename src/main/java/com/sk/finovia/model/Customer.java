package com.sk.finovia.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Customer {

    @Id
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

}
