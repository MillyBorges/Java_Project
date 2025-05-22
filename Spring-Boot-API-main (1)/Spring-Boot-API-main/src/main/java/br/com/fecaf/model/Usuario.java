package br.com.fecaf.model;

import jdk.jfr.Enabled;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Enabled
@Entity
@Table(name = "usuarios")

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    private String email;
    @Column(nullable = false)
    private String senhaHash;
    @Column(nullable = false, unique = true)
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDateTime criadoEm;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Conta> contas;

    // Construtor
    public Usuario() {}

    public Usuario(String nome, String cpf, String senhaHash, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senhaHash = senhaHash;
        this.email = email;
    }


    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }


    //UserDetails
    // Métodos da interface UserDetails

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public String getPassword() {
        return senhaHash;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aqui você pode retornar as roles/authorities do usuário
        // Por enquanto, retornamos uma lista vazia (sem permissões)
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Retorne true se a conta não expirou
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Retorne true se a conta não está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Retorne true se as credenciais (senha) não expiraram
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Retorne true se o usuário está habilitado
        return true;
    }

    // Equals e HashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id,usuario.id) && Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode (){
        return Objects.hash(id, cpf);
    }
}