package io.github.mateusdomelo.javer.service;

import io.github.mateusdomelo.javer.domain.entity.Cliente;
import io.github.mateusdomelo.javer.rest.dto.ClienteScoreDTO;

public interface ClienteService {
    Cliente obterPorId(Long id);
    Cliente salvar(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void excluir(Long id);
    ClienteScoreDTO obterScore(Long id);
}
