package br.com.fecaf.repository;

import br.com.fecaf.model.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacoes, Long>{
    List<Transacoes> findByContaOrigem(Long contaOrigem);
    List<Transacoes> findByContaDestino(Long contaDestino);
}
