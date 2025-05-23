package br.com.fecaf.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Usuario {
    @Id
    private Long cpf;
    private String nome;
    private String senha;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Conta> contas = new ArrayList<>();

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public boolean isPresent() {
        return false;
    }
}
