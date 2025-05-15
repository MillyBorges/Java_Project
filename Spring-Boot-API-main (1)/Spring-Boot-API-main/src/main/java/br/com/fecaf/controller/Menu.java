package br.com.fecaf.controller;

import br.com.fecaf.model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public void executarMenu () {


        //Referência da lista

        Pessoa refListPessoa = new Pessoa();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;


        // List para trabalhar com diversos Usuarios
        List<Pessoa> listPessoas = new ArrayList<>();

        while (continuar){

            System.out.println("/* Menu */");
            System.out.println("/* 1 - Cadastrar  ");
            System.out.println("/* 2 - Listar Pessoas  ");
            System.out.println("/* 3 - Excluir Pessoa  ");
            System.out.println("/* 4 - Sair  ");

            int userOption = scanner.nextInt();

            switch (userOption) {
                case 1:
                    Pessoa pessoa = new Pessoa();
                    pessoa.cadastrarPessoa();
                    refListPessoa.addPessoa(pessoa);
                    break;
                case 2:
                    refListPessoa.listarPessoas();
                    break;
                case 3:
                    System.out.println("Informe o CPF que deseja deletar: ");
                    long cpfDeletado = scanner.nextLong();

                    Pessoa pessoaDelete = refListPessoa.pesquisarPessoa(cpfDeletado);

                    if(pessoaDelete != null){
                        refListPessoa.deletarPessoa(pessoaDelete);
                    } else {
                        System.out.println("Usuário não cadastrado! Verifique o CPF");
                    }

                    break;
                case 4:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha uma opção valida..");
            }
        }



    }
}
