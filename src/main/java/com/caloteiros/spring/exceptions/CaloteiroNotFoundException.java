package com.caloteiros.spring.exceptions;

public class  CaloteiroNotFoundException extends RuntimeException {
    public CaloteiroNotFoundException(String message) {
        super(message);
    }
}
