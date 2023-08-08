package com.dev.ranelho.vendas.cliente.application.api;

import jakarta.validation.constraints.NotBlank;

public record ClienteUpdateRequest(
        @NotBlank String fullName
) {
}
