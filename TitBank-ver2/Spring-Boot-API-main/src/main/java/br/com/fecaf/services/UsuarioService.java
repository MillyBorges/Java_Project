package br.com.fecaf.services;


import br.com.fecaf.model.Usuario;
import br.com.fecaf.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar Usuário
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    public Usuario realizarLogin(long cpf, String senha) {
        Usuario usuario = usuarioRepository.findByCpf(cpf);

        String senhaUser = usuario.getSenha();

        if (usuario != null && senhaUser.equals(senha) ) {
            return usuario;
        }

        return null;

    }


    // listar usuarioo
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Novo Usuario
    public Usuario salvarUsuario (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Deletar Usuario
    public void deletarUsuario (Long cpf) {
        usuarioRepository.deleteByCpf(cpf);
    }


    public Usuario save(Usuario usuario) {
        return null;
    }
}
