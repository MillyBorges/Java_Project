package br.com.fecaf.repository;

import br.com.fecaf.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCpf(Long cpf);

    void deleteByCpf(Long cpf);
}