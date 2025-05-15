package br.com.fecaf.model;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Enabled
@Entity
@Table(name = "pessoa")
public class Pessoa {
    // Atributos
    private   String nome, email;
    private long cpf, rg;
    private int idade;

    // Coleta dados do terminal
    Scanner scanner = new Scanner(System.in);

    //Lista para armazenar pessoas

    List<Pessoa> listPessoas = new ArrayList<>();

    //Listar pessoas

    public void listarPessoas(){
        for (Pessoa pessoa : listPessoas){
            pessoa.exibirInformacoes();
        }
    }

    // Adicionar pessoas na lista
    public void addPessoa(Pessoa pessoa){
        listPessoas.add(pessoa);
    }

    //Deletar Pessoas da Lista

    public void deletarPessoa(Pessoa pessoa) {
        listPessoas.remove(pessoa);
    }

    // Pesquisar Pessoa

    public Pessoa pesquisarPessoa(long cpf){
        for (Pessoa pessoa : listPessoas){

            if (pessoa.getCpf() == cpf) {
                return pessoa;
            }
        }
        return null;
    }




    public void cadastrarPessoa () {
        System.out.println("/*******/");
        System.out.println("/* Cadastrar Pessoa */");
        System.out.println("/*******/");
        System.out.println("/* Informe o nome:     ");
        nome = scanner.nextLine();
        System.out.println("/* Informe o CPF:      ");
        cpf = scanner.nextLong();
        System.out.println("/* Informe o RG:       ");
        rg = scanner.nextLong();
        scanner.nextLine();
        System.out.println("/*Informe o email:     ");
        email = scanner.nextLine();
        System.out.println("/* Informe a idade:    ");
        idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("/* Cadastro Finalizado  */");
        System.out.println("/*******/");

    }

    // Exibir dados
    public void exibirInformacoes() {
        System.out.println("/*******/");
        System.out.println("/* Informações */");
        System.out.println("/*******/");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("RG: " + rg);
        System.out.println("/*******/");
    }






    // Getter and Setter

    // Get -> Buscar / Pegar
    public String getNome() {
        return nome;
    }

    // Set -> Configurar / Alterar

    public  void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

