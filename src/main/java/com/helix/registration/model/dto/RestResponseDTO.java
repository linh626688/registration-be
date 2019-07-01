package com.helix.registration.model.dto;


public class RestResponseDTO<T extends BodyResponseDTO>{

    private HeaderResponseDTO header;
    private T body;

    public RestResponseDTO() {
    }

    public RestResponseDTO(HeaderResponseDTO header, T body) {
        this.header = header;
        this.body = body;
    }

    public HeaderResponseDTO getHeader() {
        return header;
    }

    public void setHeader(HeaderResponseDTO header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
