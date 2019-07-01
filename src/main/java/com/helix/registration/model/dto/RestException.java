package com.helix.registration.model.dto;

import com.helix.registration.model.RestError;
import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException {

    private final RestError restError;
    private final HttpStatus statusCode;
    private Exception innerException;

    public RestException(RestError restError, HttpStatus statusCode) {
        this.restError = restError;
        this.statusCode = statusCode;
    }

    public RestError getRestError() {
        return restError;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public Exception getInnerException() {
        return innerException;
    }

    public void setInnerException(Exception innerException) {
        this.innerException = innerException;
    }
}
