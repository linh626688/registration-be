package com.helix.registration.model.dto;

import java.util.ArrayList;

public class ErrorResponseDTO extends BodyResponseDTO {

    public ErrorResponseDTO() {
        setErrors(new ArrayList<>());
    }
}
