package com.dev.ranelho.vendas.cliente.application.repository;

import com.dev.ranelho.vendas.cliente.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ClienteRepository {
    Cliente salvaCliente(Cliente cliente);

    Optional<Cliente> findClienteByCpf(String cpf);

    Page<Cliente> getAllClientes(Pageable pageable);

    void delete(UUID idCliente);

    List<Cliente> getClientesByName(String name);
}
