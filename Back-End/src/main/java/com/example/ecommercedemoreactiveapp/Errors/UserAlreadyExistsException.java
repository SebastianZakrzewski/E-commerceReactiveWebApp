package com.example.ecommercedemoreactiveapp.Errors;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String s) {
        super(s);
    }
}
