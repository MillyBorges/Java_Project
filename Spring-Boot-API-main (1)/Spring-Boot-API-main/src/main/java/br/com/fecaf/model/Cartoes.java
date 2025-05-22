package br.com.fecaf.model;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Enabled
@Entity
@Table(name = "cartoes")

public class Cartoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   // private Conta conta;
    private String numero;
    private LocalDate validade;
    private String cvv;
    private TipoCartao tipo;
    private BigDecimal limite;
    private LocalDateTime criadoEm;

    public enum TipoCartao { CREDITO, DEBITO }

}
