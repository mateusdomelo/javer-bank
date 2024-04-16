package io.github.mateusdomelo.javer.client;

import io.github.mateusdomelo.javer.domain.entity.Cliente;
import io.github.mateusdomelo.javer.rest.dto.ClienteScoreDAO;
import org.springframework.cloud.openfeign.FeignClient;
import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "${feign.name}",
        url = "${feign.url}/clientes",
        configuration = ClienteFeignClientConfiguration.class
)
public interface ClienteFeignClient {
    @GetMapping(value = "/{id}")
    Cliente obterPorId(@PathVariable Long id);

    @PostMapping
    @ResponseStatus(CREATED)
    Cliente criar(@RequestBody Cliente cliente);

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    void atualizar(@PathVariable Long id, @RequestBody Cliente cliente);

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    void excluir(@PathVariable Long id);

    @GetMapping("{id}/score")
    @ResponseStatus(OK)
    ClienteScoreDAO obterScore(@PathVariable Long id);
}
