package com.dev.ranelho.vendas.cliente.application.api;

import com.dev.ranelho.vendas.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse newCliente(ClienteRequest request) {
        log.info("[inicia] - ClienteRestController.newCliente");
        ClienteResponse response = clienteService.newCliente(request);
        log.info("[finaliza] - ClienteRestController.newCliente");
        return response;
    }

    @Override
    public ClienteResponse getClienteByCpf(String cpf) {
        log.info("[inicia] - ClienteRestController.getClienteByCpf");
        ClienteResponse response = clienteService.getClienteByCpf(cpf);
        log.info("[finaliza] - ClienteRestController.getClienteByCpf");
        return response;
    }

    @Override
    public Page<ClienteResponse> getAllClientes(Pageable pageable) {
        log.info("[inicia] - ClienteRestController.getAllClientes");
        Page<ClienteResponse> list = clienteService.getAllClientes(pageable);
        log.info("[finaliza] - ClienteRestController.getAllClientes");
        return list;
    }

    @Override
    public ClienteResponse updateCliente(String cpf, ClienteUpdateRequest updateRequest) {
        log.info("[inicia] - ClienteRestController.updateCliente");
        ClienteResponse response = clienteService.updateCliente(cpf,updateRequest);
        log.info("[finaliza] - ClienteRestController.updateCliente");
        return response;
    }

    @Override
    public void deleteCliente(String cpf) {
        log.info("[inicia] - ClienteRestController.deleteCliente");
        clienteService.deleteCliente(cpf);
        log.info("[finaliza] - ClienteRestController.deleteCliente");
    }

    @Override
    public List<ClienteResponse> getClientesByName(String name) {
        log.info("[inicia] - ClienteRestController.getClientesByName");
        List<ClienteResponse> list = clienteService.getClienteByName(name);
        log.info("[finaliza] - ClienteRestController.getClientesByName");
        return list;
    }
}