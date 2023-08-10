package com.dev.ranelho.vendas.cliente.application.api;

import com.dev.ranelho.vendas.validator.TrimString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequest(
        @TrimString
        @NotBlank String fullName,
        @NotBlank(message = "CPF obrigatório") @CPF(message = "CPF inválido")
        @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
        String cpf
) {
}