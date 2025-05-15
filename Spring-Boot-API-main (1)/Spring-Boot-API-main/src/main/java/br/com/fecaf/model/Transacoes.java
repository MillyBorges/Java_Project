package br.com.fecaf.model;

import jdk.jfr.Enabled;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Enabled
@Entity
@Table(name = "transacoes")

public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "conta_origem_id")
    private Conta contaOrigem;
    @ManyToOne
    @JoinColumn(name = "conta_destino_id")
    private Conta contaDestino;
    private TipoTransacao tipo;
    private BigDecimal valor;
    private LocalDateTime dataTransacao = LocalDateTime.now();

    public enum TipoTransacao { DEPOSITO, SAQUE, TRANSFERENCIA }

    // Getter e Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
