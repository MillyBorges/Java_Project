package br.com.fecaf.model;

import javax.persistence.*;

@Entity
@Table (name = "chaves_pix")
public class ChavePix {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String chave;
    private int conta_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public int getConta() {
        return conta_id;
    }

    public void setConta(int conta_id) {
        this.conta_id = conta_id;
    }
}
