package com.dev.ranelho.vendas.cliente.infra;

import com.dev.ranelho.vendas.cliente.application.repository.ClienteRepository;
import com.dev.ranelho.vendas.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.dev.ranelho.vendas.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

    private final ClienteJpaRepository jpaRepository;

    @Override
    public Cliente salvaCliente(Cliente cliente) {
        try {
            log.info("[inicia] - ClienteInfraRepository.newCliente");
            return jpaRepository.save(cliente);
        }catch (Exception e){
            throw build(BAD_REQUEST,"Cliente já cadastrado");
        }
    }

    @Override
    public Optional<Cliente> findByCpf(String cpf) {
        log.info("[inicia] - ClienteInfraRepository.newCliente");
        Optional<Cliente> optionalCliente = jpaRepository.findByCpf(cpf);
        log.info("[finaliza] - ClienteInfraRepository.newCliente");
        return  optionalCliente;
    }

    @Override
    public Page<Cliente> getAllClientes(Pageable pageable) {
        log.info("[inicia] - ClienteInfraRepository.getAllClientes");
        Page<Cliente> clientes = jpaRepository.findAll(pageable);
        log.info("[finaliza] - ClienteInfraRepository.getAllClientes");
        return clientes;
    }

    @Override
    public void delete(UUID idCliente) {
        log.info("[inicia] - ClienteInfraRepository.delete");
        jpaRepository.deleteById(idCliente);
        log.info("[finaliza] - ClienteInfraRepository.delete");
    }

    @Override
    public List<Cliente> getClientesByName(String name) {
        log.info("[inicia] - ClienteInfraRepository.getClientesByName");
        List<Cliente> clientes = jpaRepository.findAllByFullNameContainingIgnoreCase(name);
        log.info("[finaliza] - ClienteInfraRepository.getClientesByName");
        return clientes;
    }
}
