package com.food.response;

import com.food.model.User_ROLE;

import lombok.Data;


@Data
public class AuthResponse {

    private String jwt;

    private String message;

    private User_ROLE role;

}
