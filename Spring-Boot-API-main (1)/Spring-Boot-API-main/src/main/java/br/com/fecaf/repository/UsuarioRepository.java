package br.com.fecaf.repository;

import br.com.fecaf.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByCpf(String cpf);
}
