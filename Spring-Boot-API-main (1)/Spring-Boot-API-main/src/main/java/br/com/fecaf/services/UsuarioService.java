package br.com.fecaf.services;


import br.com.fecaf.model.Usuario;
import br.com.fecaf.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar Usuário
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar Usuário por CPF
    public Usuario buscarPorCpf (String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }




}
