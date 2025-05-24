package br.com.fecaf.services;

import br.com.fecaf.model.ChavePix;
import br.com.fecaf.model.Conta;
import br.com.fecaf.model.Transacao;
import br.com.fecaf.repository.ChavePixRepository;
import br.com.fecaf.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PixService {
    private final ChavePixRepository chavePixRepository;
    private final TransacaoRepository transacaoRepository;


    @Autowired
    private ContaService contaService;



    public PixService(ChavePixRepository chavePixRepository, TransacaoRepository transacaoRepository) {
        this.chavePixRepository = chavePixRepository;
        this.transacaoRepository = transacaoRepository;
    }



    public String enviarPix(String chavePix, Double valor) {
          Optional<ChavePix> chave = chavePixRepository.findByChave(chavePix);

        System.out.println(chave.get().getConta());
        Optional<Conta> conta = contaService.findById(chave.get().getConta());

        Conta contaUser = conta.get();
        System.out.println(contaUser.getSaldo());

         //Optional<Conta> conta = contaService.findById(chave.get().getConta());

       // System.out.println(conta.get().getSaldo());

//        if (chave == null) {
//            System.out.println("Ta errado essa poha!!!");
//           // throw new RuntimeException("Chave PIX não encontrada");
//        }



//        Transacao transacao = new Transacao();
//        transacao.setValor(valor);
//        transacao.setTipo("PIX");
//        transacao.setData(LocalDateTime.now());
//        transacao.setConta(chave.get().getConta());
//        transacaoRepository.save(transacao);
        return "PIX enviado com sucesso!";
    }
}