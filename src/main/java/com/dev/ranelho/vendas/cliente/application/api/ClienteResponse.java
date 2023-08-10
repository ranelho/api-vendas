package com.dev.ranelho.vendas.cliente.application.api;

import com.dev.ranelho.vendas.cliente.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;

public record ClienteResponse(
        String fullName, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao
) {
    public ClienteResponse(Cliente cliente) {
        this(cliente.getFullName(), cliente.getDataCadastro(), cliente.getUltimaAtualizacao());
    }

    public static Page<ClienteResponse> convertePage(Page<Cliente> clientes) {
        List<ClienteResponse> clienteResponses = clientes.getContent().stream()
                .map(cliente -> new ClienteResponse(cliente.getFullName(), cliente.getDataCadastro(),
                        cliente.getUltimaAtualizacao()))
                .toList();
        return new PageImpl<>(clienteResponses, clientes.getPageable(), clientes.getTotalElements());
    }

    public static List<ClienteResponse> converteList(List<Cliente> clientes) {
        return clientes.stream()
                .map(cliente -> new ClienteResponse(cliente.getFullName(), cliente.getDataCadastro(),
                        cliente.getUltimaAtualizacao()))
                .toList();
    }
}