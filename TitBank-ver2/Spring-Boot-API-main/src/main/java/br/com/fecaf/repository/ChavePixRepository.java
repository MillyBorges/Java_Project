package br.com.fecaf.repository;

import br.com.fecaf.model.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChavePixRepository extends JpaRepository<ChavePix, Long> {
    ChavePix findByChave(String chavePix);
}