package br.com.fecaf.repository;

import br.com.fecaf.model.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ChavePixRepository extends JpaRepository<ChavePix, Long> {
    Optional<ChavePix> findByChave(String chave);

}