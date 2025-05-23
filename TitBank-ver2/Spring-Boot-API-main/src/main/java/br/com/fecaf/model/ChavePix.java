package br.com.fecaf.model;

import javax.persistence.*;

@Entity
@Table (name = "chaves_pix")
public class ChavePix {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chave;
    @ManyToOne
    private Conta conta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
