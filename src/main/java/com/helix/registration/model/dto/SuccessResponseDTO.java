package com.helix.registration.model.dto;

public class SuccessResponseDTO extends BodyResponseDTO {

    private boolean status;
    private String message;

    public SuccessResponseDTO(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
