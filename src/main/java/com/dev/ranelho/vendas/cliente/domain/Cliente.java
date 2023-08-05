package com.dev.ranelho.vendas.cliente.domain;

import com.dev.ranelho.vendas.cliente.application.api.ClienteRequest;
import com.dev.ranelho.vendas.cliente.application.api.ClienteUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_vendas")
@EntityListeners(AuditingEntityListener.class)
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
    @LastModifiedDate
    private LocalDateTime ultimaAtualizacao;

    public Cliente(ClienteRequest request) {
        this.fullName = request.fullName().toUpperCase();
        this.cpf = request.cpf();
    }

    public void update(ClienteUpdateRequest updateRequest) {
        this.fullName = updateRequest.fullName();
    }
}
