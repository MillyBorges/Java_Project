package br.com.fecaf.services;

import br.com.fecaf.model.Conta;
import br.com.fecaf.model.Transacoes;
import br.com.fecaf.repository.ContaRepository;
import br.com.fecaf.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Transactional
    public Transacoes realizarTransacao(Transacoes transacoes) {
        if (transacoes.getContaOrigem() == null || transacoes.getContaDestino() == null){
            throw new IllegalArgumentException("Contas de origem e destino devem ser informadas.");
        }
        if  (transacoes.getValor() == null || transacoes.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor da transação deve ser maior que zero.");
        }
        Optional<Conta>contaOrigemOpt = contaRepository.findById(transacoes.getContaOrigem().getId());
        Optional<Conta>contaDestinoOpt = contaRepository.findById(transacoes.getContaDestino().getId());
        if (!contaOrigemOpt.isPresent()){
            throw new IllegalArgumentException("Conta de origem não encontrada.");
        }
        if (!contaDestinoOpt.isPresent()){
            throw new IllegalArgumentException("Conta de destino não encontrada.");
        }
        Conta contaOrigem = contaOrigemOpt.get();
        Conta contaDestino = contaDestinoOpt.get();

        BigDecimal valor = transacoes.getValor();
        if (contaOrigem.getSaldo().compareTo(valor) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente na conta de origem.");
        }

        // Atualiza saldo
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        // Atualiza contas no banco
        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);

        // Completa dados das transações
        transacoes.setContaOrigem(contaOrigem);
        transacoes.setContaDestino(contaDestino);

        transacoes.setDataTransacao(LocalDateTime.now());

        transacoes.setTipo(Transacoes.TipoTransacao.TRANSFERENCIA);
        return transacaoRepository.save(transacoes);

    }

}
