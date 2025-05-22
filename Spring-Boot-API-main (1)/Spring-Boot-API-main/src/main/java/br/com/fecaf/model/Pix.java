package br.com.fecaf.model;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.time.LocalDateTime;

@Enabled
@Entity
@Table(name = "pix_chaves")

public class Pix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private Conta conta;
    private TipoChavePix tipo;
    private String chave;
    private LocalDateTime criadaEm;

    public enum TipoChavePix {CPF, EMAIL, TELEFONE, ALEATORIA}
}