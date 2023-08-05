package com.dev.ranelho.vendas.cliente.application.api;

import com.dev.ranelho.vendas.cliente.domain.Cliente;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ClienteResponse {
    String fullName;
    LocalDateTime dataCadastro;

    public ClienteResponse(Cliente cliente) {
        this.fullName = cliente.getFullName();
        this.dataCadastro = cliente.getDataCadastro();
    }
}
