package com.dev.ranelho.vendas.cliente.infra;

import com.dev.ranelho.vendas.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteJpaRepository  extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByCpf(String cpf);

    List<Cliente> findAllByFullNameContainingIgnoreCase(String name);
}
