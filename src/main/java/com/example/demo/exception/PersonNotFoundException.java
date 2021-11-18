package com.example.demo.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        System.out.println("id wont exist" + id);
    }
}


