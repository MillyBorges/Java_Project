package br.com.fecaf.model;

import jdk.jfr.Enabled;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Enabled
@Entity
@Table(name = "contas")
public class Conta {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numeroConta;
    private String agencia = "XX-666";
    private String password, confirmPassword;
    private BigDecimal saldo = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //@OneToMany(mappedBy = "contas", cascade = CascadeType.ALL)
    //private List<Transacoes> transacoes;


    // Construtor
    public Conta() {}

    public Conta(Usuario usuario, String numeroConta) {
        this.usuario = usuario;
        this.numeroConta = numeroConta;
    }

    //Getter e Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   // public List<Transacoes> getTransacoes() {
    //    return transacoes;
    //}

    //public void setTransacoes(List<Transacoes> transacoes) {
    //    this.transacoes = transacoes;
   // }
}
