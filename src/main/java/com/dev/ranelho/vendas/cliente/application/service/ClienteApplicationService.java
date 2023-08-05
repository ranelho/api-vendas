package com.dev.ranelho.vendas.cliente.application.service;

import com.dev.ranelho.vendas.cliente.application.api.ClienteAPI;
import com.dev.ranelho.vendas.cliente.application.api.ClienteRequest;
import com.dev.ranelho.vendas.cliente.application.api.ClienteResponse;
import com.dev.ranelho.vendas.cliente.application.repository.ClienteRepository;
import com.dev.ranelho.vendas.cliente.domain.Cliente;
import com.dev.ranelho.vendas.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse newCLiente(ClienteRequest request) {
        log.info("[inicia] - ClienteApplicationService.ClienteResponse");
        Optional<Cliente> optionalCliente = clienteRepository.findByCpf(request.cpf());
        if(optionalCliente.isPresent()){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Cpf ja ultilizado!");
        }
        Cliente cliente = clienteRepository.newCliente(new Cliente(request));
        log.info("[finaliza] - ClienteApplicationService.ClienteResponse");
        return new ClienteResponse(cliente);
    }
}
