package br.com.fecaf.controller;

import br.com.fecaf.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaController {




    List<Conta> listConta = new ArrayList<>();

    // Adicionar Conta
    public void addConta (Conta conta) {
        listConta.add(conta);
    }

    // Pesquisar Conta
    public Conta searchConta (String cpf) {

        for (Conta conta : listConta) {
            if (conta.getUsuario().getCpf().equals(cpf)){
                return conta;
            }
        }
        return null;
    }


}