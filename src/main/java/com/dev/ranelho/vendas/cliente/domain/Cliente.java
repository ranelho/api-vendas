package com.dev.ranelho.vendas.cliente.domain;

import com.dev.ranelho.vendas.cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vendas")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    private String fullName;
    @CPF
    @Column(unique = true, updatable = false)
    private String cpf;
    @CreatedDate
    private LocalDateTime dataCadastro;

    public Cliente(ClienteRequest request) {
        this.fullName = request.fullName();
        this.cpf = request.cpf();
    }
}
