package io.github.mateusdomelo.javer.rest;

import lombok.Getter;

@Getter
public class RequestErrors {
    private final String responseMessage;

    public RequestErrors(String message) {
        this.responseMessage = message;
    }
}
