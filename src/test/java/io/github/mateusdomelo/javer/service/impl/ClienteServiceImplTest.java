package io.github.mateusdomelo.javer.service.impl;

import io.github.mateusdomelo.javer.client.ClienteFeignClient;
import io.github.mateusdomelo.javer.domain.entity.Cliente;
import io.github.mateusdomelo.javer.exception.ClienteNotFoundException;
import io.github.mateusdomelo.javer.exception.NotFoundException;
import io.github.mateusdomelo.javer.rest.dto.ClienteScoreDTO;
import io.github.mateusdomelo.javer.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClienteServiceImplTest {

    @MockBean
    private ClienteFeignClient feignMock;

    @Autowired
    ClienteService clienteService;

    @Test
    void obterPorId_ShouldReturnClienteFromFeignClient() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(id);

        /* Actions */
        when(feignMock.obterPorId(id)).thenReturn(cliente);
        Cliente result = clienteService.obterPorId(id);

        /* Verifications */
        assertEquals(id, result.getId());
        assertInstanceOf(Cliente.class, result);
    }

    @Test
    void obterPorId_WithNonExistingCliente_ShouldThrowClienteNotFoundException() {
        Long id = 1L;

        /* Actions */
        when(feignMock.obterPorId(id)).thenThrow(new NotFoundException(""));

        /* Verifications */
        assertThrows(ClienteNotFoundException.class, () -> clienteService.obterPorId(id));
    }

    @Test
    void salvar_ShouldReturnClienteFromFeignClient() {
        Cliente cliente = new Cliente();

        /* Actions */
        when(clienteService.salvar(cliente)).thenReturn(cliente);
        Cliente result = clienteService.salvar(cliente);

        /* Verifications */
        assertEquals(cliente, result);
        assertInstanceOf(Cliente.class, result);
    }

    @Test
    void atualizar_ShouldHaveSuccessFromFeignClient() {
        Long id = 1L;
        Cliente cliente = new Cliente();

        /* Actions */
        doNothing().when(feignMock).atualizar(id, cliente);

        clienteService.atualizar(id, cliente);

        /* Verifications */
        verify(feignMock, atMostOnce()).atualizar(id, cliente);
    }

    @Test
    void atualizar_WithNonExistingCliente_ShouldThrowClienteNotFoundException() {
        Long id = 1L;
        Cliente cliente = new Cliente();

        /* Actions */
        doThrow(new NotFoundException("")).when(feignMock).atualizar(id, cliente);

        /* Verifications */
        assertThrows(NotFoundException.class, () -> clienteService.atualizar(id, cliente));
    }

    @Test
    void excluir_ShouldHaveSuccessFromFeignClient() {
        Long id = 1L;

        /* Actions */
        doNothing().when(feignMock).excluir(id);
        clienteService.excluir(id);

        /* Verifications */
        verify(feignMock, atMostOnce()).excluir(id);
    }

    @Test
    void excluir_WithNonExistingCliente_ShouldThrowClienteNotFoundException() {
        Long id = 1L;

        /* Actions */
        doThrow(new NotFoundException("")).when(feignMock).excluir(id);

        /* Verifications */
        assertThrows(ClienteNotFoundException.class, () -> clienteService.excluir(id));
    }

    @Test
    void obterScore_ShouldReturnClienteScoreDAOFromFeignClient() {
        Long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setNome("Some Name");
        cliente.setScoreCredito(100);
        cliente.setSaldoCc(100);

        /* Actions */
        when(feignMock.obterPorId(id)).thenReturn(cliente);
        ClienteScoreDTO result = clienteService.obterScore(id);

        /* Verifications */
        assertInstanceOf(ClienteScoreDTO.class, result);
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getScoreCredito(), result.getScore());
    }

    @Test
    void obterScore_WithNonExistingCliente_ShouldThrowClienteNotFoundException() {
        Long id = 1L;

        /* Actions */
        when(feignMock.obterPorId(id)).thenThrow(NotFoundException.class);

        /* Verifications */
        assertThrows(ClienteNotFoundException.class, () -> clienteService.obterScore(id));
    }
}