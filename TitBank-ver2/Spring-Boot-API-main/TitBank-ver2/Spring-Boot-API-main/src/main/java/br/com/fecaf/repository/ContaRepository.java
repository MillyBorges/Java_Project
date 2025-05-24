package br.com.fecaf.repository;

import br.com.fecaf.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContaRepository extends JpaRepository<Conta, Integer> {

}