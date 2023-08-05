package com.dev.ranelho.vendas.cliente.application.api;

import com.dev.ranelho.vendas.cliente.domain.Cliente;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class ClienteResponse {
    String fullName;
    LocalDateTime dataCadastro;
    LocalDateTime dataAtualizacao;

    public ClienteResponse(Cliente cliente) {
        this.fullName = cliente.getFullName();
        this.dataCadastro = cliente.getDataCadastro();
        this.dataAtualizacao = cliente.getUltimaAtualizacao();
    }

    public static Page<ClienteResponse> convertePage(Page<Cliente> clientes) {
        List<ClienteResponse> clienteResponses = clientes.getContent().stream()
                .map(ClienteResponse::new)
                .toList();

        return new PageImpl<>(clienteResponses, clientes.getPageable(), clientes.getTotalElements());
    }

    public static List<ClienteResponse> converteList(List<Cliente> clientes) {
        return clientes
                .stream()
                .map(ClienteResponse::new)
                .toList();
    }
}
