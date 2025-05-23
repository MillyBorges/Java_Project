package br.com.fecaf.controller;

import br.com.fecaf.model.Usuario;
import br.com.fecaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/cadastro")
    public class CadastroController {

        @Autowired
        private UsuarioService usuarioService;

        @PostMapping
        public ResponseEntity<?> cadastrar(@RequestBody CadastroRequest cadastroRequest) {
            Usuario userCadastro = usuarioService.criarUsuario(cadastroRequest.nome, cadastroRequest.cpf, cadastroRequest.senha);
            // Verifica se o CPF já está cadastrado
            if (usuarioService.criarUsuario(Usuario usuario).findByCpf(usuario.getCpf()) != null) {
                return ResponseEntity.badRequest().body("{\"message\": \"CPF já cadastrado.\"}");
            }

            usuarioService.save(usuario);
            return ResponseEntity.ok("{\"message\": \"Cadastro realizado com sucesso!\"}");
        }

        public static class CadastroRequest {
            public String nome;
            public Long cpf;
            public String senha;
        }

    }

