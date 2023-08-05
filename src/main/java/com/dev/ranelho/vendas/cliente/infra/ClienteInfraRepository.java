package com.dev.ranelho.vendas.cliente.infra;

import com.dev.ranelho.vendas.cliente.application.repository.ClienteRepository;
import com.dev.ranelho.vendas.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteJpaRepository jpaRepository;

    @Override
    public Cliente newCliente(Cliente cliente) {
        log.info("[inicia] - ClienteInfraRepository.newCliente");
        jpaRepository.save(cliente);
        log.info("[finaliza] - ClienteInfraRepository.newCliente");
        return cliente;
    }

    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        log.info("[inicia] - ClienteInfraRepository.newCliente");
        Optional<Cliente> optionalCliente = jpaRepository.findByCpf(cpf);
        log.info("[finaliza] - ClienteInfraRepository.newCliente");
        return  optionalCliente;
    }
}
