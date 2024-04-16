package io.github.mateusdomelo.javer.rest.controller;

import io.github.mateusdomelo.javer.domain.entity.Cliente;
import io.github.mateusdomelo.javer.rest.dto.ClienteScoreDAO;
import io.github.mateusdomelo.javer.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService clienteService) {
        this.service = clienteService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(
            description = "Criar novo cliente",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "As informações digitadas são inválidas"),
            }

    )
    public Cliente salvar(@Valid @RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(OK)
    @Operation(
            description = "Obter cliente através do id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado dado o id informado")
            }
    )
    public Cliente obterPorId(@PathVariable Long id) {
        return service.obterPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
            description = "Atualizar cliente existente através do id",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Cliente atualizado com êxito"),
                    @ApiResponse(responseCode = "400", description = "As informações digitadas são inválidas"),
                    @ApiResponse(responseCode = "404", description = "Cliente inexistente para o id informado")
            }

    )
    public void atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        service.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Operation(
            description = "Excluir cliente existente através do id",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Score de crédito obtido com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Cliente inexistente para o id informado")
            }

    )
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/{id}/score")
    @ResponseStatus(OK)
    @Operation(
            description = "Obter o score de crédito para o cliente informado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Cliente atualizado com êxito"),
                    @ApiResponse(responseCode = "404", description = "Cliente não encontrado dado o id informado")
            }

    )
    public ClienteScoreDAO obterScore(@PathVariable Long id) {
        return service.obterScore(id);
    }
}
