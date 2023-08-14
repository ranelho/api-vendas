package com.dev.ranelho.vendas.cliente.application.api;

import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequestMapping("/v1/clientes")
@Validated
public interface ClienteAPI {

    @PostMapping
    @ResponseStatus(CREATED)
    ClienteResponse newCliente(@Valid @RequestBody ClienteRequest request);

    @GetMapping("/{cpf}")
    @ResponseStatus(OK)
    ClienteResponse getClienteByCpf(@PathVariable("cpf") @CPF(message = "CPF inválido!") String cpf);

    @GetMapping()
    @ResponseStatus(OK)
    Page<ClienteResponse> getAllClientes(Pageable pageable);

    @PutMapping("/{cpf}")
    @ResponseStatus(OK)
    ClienteResponse updateCliente(@PathVariable("cpf") @CPF(message = "CPF inválido!") String cpf,
                                  @RequestBody ClienteUpdateRequest updateRequest);

    @DeleteMapping("/{cpf}")
    @ResponseStatus(NO_CONTENT)
    void deleteCliente(@PathVariable("cpf") @CPF(message = "CPF inválido!") String cpf);

    @GetMapping("/nome/{name}")
    @ResponseStatus(OK)
    List<ClienteResponse> getClientesByName(@PathVariable("name") String name);
}
