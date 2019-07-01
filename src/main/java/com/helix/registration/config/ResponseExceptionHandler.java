package com.helix.registration.config;

import com.helix.registration.model.RestError;
import com.helix.registration.model.dto.ErrorResponseDTO;
import com.helix.registration.model.dto.RestException;
import com.helix.registration.model.dto.RestResponseDTO;
import com.helix.registration.model.dto.RestResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(RestException.class)
    public ResponseEntity<RestResponseDTO<ErrorResponseDTO>> handleRestException(HttpServletRequest request, RestException ex) {
        RestResponseDTO<ErrorResponseDTO> errorResponse = RestResponseWrapper.wrapErrorResponse(
                ex.getRestError(),
                ex.getStatusCode()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponseDTO<ErrorResponseDTO>> handleOtherException(HttpServletRequest request, Exception ex) {
        RestResponseDTO<ErrorResponseDTO> errorResponse = RestResponseWrapper.wrapErrorResponse(
                RestError.INTERNAL_SERVER_ERROR,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

}
