package com.dev.ranelho.vendas.cliente.application.service;

import com.dev.ranelho.vendas.cliente.application.api.ClienteUpdateRequest;
import com.dev.ranelho.vendas.cliente.application.api.ClienteRequest;
import com.dev.ranelho.vendas.cliente.application.api.ClienteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {
    ClienteResponse newCliente(ClienteRequest request);
    ClienteResponse getClienteByCpf(String cpf);
    Page<ClienteResponse> getAllClientes(Pageable pageable);
    ClienteResponse updateCliente(String cpf, ClienteUpdateRequest updateRequest);
    void deleteCliente(String cpf);
    List<ClienteResponse> getClienteByName(String name);
}
