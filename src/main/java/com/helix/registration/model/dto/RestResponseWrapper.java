package com.helix.registration.model.dto;

import com.helix.registration.model.RestError;
import org.springframework.http.HttpStatus;

public class RestResponseWrapper {

    private RestResponseWrapper() {}

    public static RestResponseDTO<ErrorResponseDTO> wrapErrorResponse(RestError restError, HttpStatus errorHttpStatus) {
        RestResponseDTO<ErrorResponseDTO> response = new RestResponseDTO<>();
        response.setHeader(new HeaderResponseDTO(
                false,
                Integer.toString(errorHttpStatus.value()),
                errorHttpStatus.getReasonPhrase()
        ));

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.getErrors().add(new ErrorDTO(
                restError.name(),
                restError.getMessage()
        ));
        response.setBody(errorResponseDTO);

        return response;
    }

    public static <T extends BodyResponseDTO> RestResponseDTO<T> wrapSuccessResponse(T bodyResponse) {
        RestResponseDTO<T> response = new RestResponseDTO<>();
        response.setHeader(new HeaderResponseDTO(
                true,
                Integer.toString(HttpStatus.OK.value()),
                HttpStatus.OK.name()
        ));
        response.setBody(bodyResponse);
        return response;
    }
}
