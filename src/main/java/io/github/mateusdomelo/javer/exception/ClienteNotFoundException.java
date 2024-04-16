package io.github.mateusdomelo.javer.exception;

public class ClienteNotFoundException extends NotFoundException {
    public ClienteNotFoundException(Long clienteId) {
        super("Cliente não encontrado com o ID '" + clienteId + "'");
    }
}
