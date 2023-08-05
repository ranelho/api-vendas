package com.dev.ranelho.vendas.cliente.application.service;

import com.dev.ranelho.vendas.cliente.application.api.ClienteRequest;
import com.dev.ranelho.vendas.cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse newCLiente(ClienteRequest request);
}
