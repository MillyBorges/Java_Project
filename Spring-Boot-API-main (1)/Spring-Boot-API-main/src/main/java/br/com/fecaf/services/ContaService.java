package br.com.fecaf.services;

import br.com.fecaf.model.Conta;
import br.com.fecaf.model.Usuario;
import br.com.fecaf.repository.ContaRepository;
import br.com.fecaf.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    UsuarioService usuarioService;

    public Conta criarConta(Long usuarioId) {
        Usuario usuario = usuarioService.buscarPorCpf(usuarioId.toString());
        String numeroConta = gerarNumeroConta();
        Conta conta = new Conta(usuario, numeroConta);
        return  contaRepository.save(conta);

    }

    private String gerarNumeroConta(){
        return String.format("%08d", new Random().nextInt(100000000));
    }

}
