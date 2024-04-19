package io.github.mateusdomelo.javer.rest;

public record RequestErrors(String responseMessage) {
    public String getResponseMessage() {
        return responseMessage;
    }
}
