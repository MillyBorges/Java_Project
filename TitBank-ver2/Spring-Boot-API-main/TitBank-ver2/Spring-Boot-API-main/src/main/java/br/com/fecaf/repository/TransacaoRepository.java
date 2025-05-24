package br.com.fecaf.repository;

import br.com.fecaf.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacaoRepository extends JpaRepository<Transacao, Long> {}