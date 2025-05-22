package br.com.fecaf.services;

import br.com.fecaf.model.Conta;
import br.com.fecaf.model.Usuario;
import br.com.fecaf.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Random;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Conta criarConta(String cpfUsuario) {
        Usuario usuario = usuarioService.buscarPorCpf(cpfUsuario);
        String numeroConta = gerarNumeroConta();
        Conta conta = new Conta(usuario, numeroConta);
        return contaRepository.save(conta);
    }

    public Conta buscarContaPorCpf(String cpf) {
        Usuario usuario = usuarioService.buscarPorCpf(cpf);
        return contaRepository.findByNumeroConta(cpf);
    }

    public BigDecimal buscarSaldoPorCpf(String cpf) {
        Conta conta = buscarContaPorCpf(cpf);
        return conta.getSaldo();
    }

    private String gerarNumeroConta() {
        return String.format("%08d", new Random().nextInt(100000000));
    }
}
