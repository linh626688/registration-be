package com.helix.registration.model.dto;


public class HeaderResponseDTO {

    private boolean success;
    private String statusCode;
    private String statusMessage;

    public HeaderResponseDTO() {
    }

    public HeaderResponseDTO(boolean success, String statusCode, String statusMessage) {
        this.success = success;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
