package com.helix.registration.model;

public enum RestError {
    NOT_FOUND("NOT_FOUND"),
    PHONE_NUMBER_IS_EXITS("PHONE_NUMBER_IS_EXITS"),
    EMAIL_IS_EXITS("EMAIL_IS_EXITS");


    private String message;

    RestError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
