package br.com.fecaf.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
public class Transacao {
         @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Double valor;
        private String tipo;
        private LocalDateTime data;
        @ManyToOne
        private Conta conta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
