package br.com.fecaf.model;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Enabled
@Entity
@Table(name = "emprestimos")

public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   // private Conta conta;
    private BigDecimal valorSolicitado;
    private BigDecimal valorTotal;
    private int parcelas;
    private BigDecimal jurosMensal;
    private StatusEmprestimo status;
    private LocalDateTime criadoEm;

    public enum StatusEmprestimo { PENDENTE, APROVADO, REJEITADO, QUITADO }
}
