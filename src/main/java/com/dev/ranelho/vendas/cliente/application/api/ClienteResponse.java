package com.dev.ranelho.vendas.cliente.application.api;

import com.dev.ranelho.vendas.cliente.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.List;

public record ClienteResponse(
        String fullName, String cpf, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao
) {
    public ClienteResponse(Cliente cliente) {
        this(cliente.getFullName(), formatarCpf(cliente.getCpf()), cliente.getDataCadastro(), cliente.getUltimaAtualizacao());
    }
    public static Page<ClienteResponse> convertePage(Page<Cliente> clientes) {
        return new PageImpl<>(
            clientes.get().map(c -> new ClienteResponse(c.getFullName(), formatarCpf(c.getCpf()),
                            c.getDataCadastro(), c.getUltimaAtualizacao()))
                    .toList(),
            clientes.getPageable(),
            clientes.getTotalElements()
        );
    }
    public static List<ClienteResponse> converteList(List<Cliente> clientes) {
        return clientes.stream()
            .map(c -> new ClienteResponse(c.getFullName(),formatarCpf(c.getCpf()), c.getDataCadastro(),
                    c.getUltimaAtualizacao()))
            .toList();
    }
    private static String formatarCpf(String cpf) {
        String parte1 = cpf.substring(0, 3);
        String parte4 = cpf.substring(9, 11);
        return String.format("%s.xxx.xxx-%s", parte1, parte4);
    }
}