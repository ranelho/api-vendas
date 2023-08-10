package com.dev.ranelho.vendas.cliente.application.service;

import com.dev.ranelho.vendas.cliente.application.api.ClienteRequest;
import com.dev.ranelho.vendas.cliente.application.api.ClienteResponse;
import com.dev.ranelho.vendas.cliente.application.api.ClienteUpdateRequest;
import com.dev.ranelho.vendas.cliente.application.repository.ClienteRepository;
import com.dev.ranelho.vendas.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dev.ranelho.vendas.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse newCliente(ClienteRequest request) {
        log.info("[inicia] - ClienteApplicationService.ClienteResponse");
        if (clienteRepository.findClienteByCpf(request.cpf()).isPresent()) {
            throw build(BAD_REQUEST, "Cpf ja utilizado!");
        }
        var cliente = clienteRepository.salvaCliente(new Cliente(request));
        log.info("[finaliza] - ClienteApplicationService.ClienteResponse");
        return new ClienteResponse(cliente);
    }

    @Override
    public ClienteResponse getClienteByCpf(String cpf) {
        log.info("[inicia] - ClienteApplicationService.findByCpf");
        Cliente cliente = validateAndGetClienteByCpf(cpf);
        log.info("[finaliza] - ClienteApplicationService.findByCpf");
        return new ClienteResponse(cliente);
    }

    @Override
    public Page<ClienteResponse> getAllClientes(Pageable pageable) {
        log.info("[inicia] - ClienteApplicationService - getAllClientes");
        Page<Cliente> clientes = clienteRepository.getAllClientes(pageable);
        log.info("[finaliza] - ClienteApplicationService - getAllClientes");
        return ClienteResponse.convertePage(clientes);
    }

    @Override
    public ClienteResponse updateCliente(String cpf, ClienteUpdateRequest updateRequest) {
        log.info("[inicia] - ClienteApplicationService.getAllClientes");
        Cliente cliente = validateAndGetClienteByCpf(cpf);
        cliente.update(updateRequest);
        clienteRepository.salvaCliente(cliente);
        log.info("[finaliza] - ClienteApplicationService.getAllClientes");
        return new ClienteResponse(cliente);
    }

    @Override
    public void deleteCliente(String cpf) {
        log.info("[inicia] - ClienteApplicationService.getAllClientes");
        clienteRepository.delete(validateAndGetClienteByCpf(cpf).getIdCliente());
        log.info("[finaliza] - ClienteApplicationService.getAllClientes");
    }

    @Override
    public List<ClienteResponse> getClienteByName(String name) {
        log.info("[inicia] - ClienteApplicationService.getClienteByName");
        List<Cliente> clientes = clienteRepository.getClientesByName(name);
        log.info("[finaliza] - ClienteApplicationService.getClienteByName");
        return ClienteResponse.converteList(clientes);
    }

    private Cliente validateAndGetClienteByCpf(String cpf) {
        return clienteRepository.findClienteByCpf(cpf)
                .orElseThrow(() -> build(BAD_REQUEST, "Cliente não encontrado!"));
    }
}
