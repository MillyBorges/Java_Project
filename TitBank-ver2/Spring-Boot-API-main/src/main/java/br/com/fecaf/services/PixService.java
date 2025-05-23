package br.com.fecaf.services;

import br.com.fecaf.model.ChavePix;
import br.com.fecaf.model.Transacao;
import br.com.fecaf.repository.ChavePixRepository;
import br.com.fecaf.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PixService {
    private final ChavePixRepository chavePixRepository;
    private final TransacaoRepository transacaoRepository;

    public PixService(ChavePixRepository chavePixRepository, TransacaoRepository transacaoRepository) {
        this.chavePixRepository = chavePixRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public String enviarPix(String chavePix, Double valor) {
        ChavePix chave = chavePixRepository.findByChave(chavePix);
        if (chave == null) {
            throw new RuntimeException("Chave PIX não encontrada");
        }
        Transacao transacao = new Transacao();
        transacao.setValor(valor);
        transacao.setTipo("PIX");
        transacao.setData(LocalDateTime.now());
        transacao.setConta(chave.getConta());
        transacaoRepository.save(transacao);
        return "PIX enviado com sucesso!";
    }
}