package com.dev.ranelho.vendas.cliente.application.repository;

import com.dev.ranelho.vendas.cliente.domain.Cliente;

import java.util.Optional;


public interface ClienteRepository {
    Cliente newCliente(Cliente cliente);

    Optional<Cliente> findByCpf(String cpf);
}
