package br.com.fecaf.services;

import br.com.fecaf.model.Usuario;
import br.com.fecaf.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar Usuário
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar Usuário por CPF
    public Usuario buscarPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }


    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpf(cpf);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com CPF: " + cpf);
        }
        return usuario;
    }
}
