package br.com.fecaf.repository;

import br.com.fecaf.model.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacoes, Long>{
}
