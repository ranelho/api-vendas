package com.dev.ranelho.vendas.cliente.application.api;

import com.dev.ranelho.vendas.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse newCliente(ClienteRequest request) {
        log.info("[inicia] - ClienteRestController.newCliente");
        ClienteResponse response = clienteService.newCLiente(request);
        log.info("[finaliza] - ClienteRestController.newCliente");
        return response;
    }

    @Override
    public ClienteResponse getByCpf(String cpf) {
        log.info("[inicia] - ClienteRestController.newCliente");
        ClienteResponse response = clienteService.findByCpf(cpf);
        log.info("[finaliza] - ClienteRestController.newCliente");
        return response;
    }
}
