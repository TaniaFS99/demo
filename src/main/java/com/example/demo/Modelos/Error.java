package com.example.demo.Modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error extends Exception{

    @JsonProperty("codigo")
    private String statusCode;
    @JsonProperty("error")
    private String message;


    public Error(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
