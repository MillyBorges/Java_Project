package br.com.fecaf.controller;

import br.com.fecaf.model.Usuario;
import br.com.fecaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/cadastro")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class CadastroController {

        @Autowired
        private UsuarioService usuarioService;

        @PostMapping("/cadastrarUser")
        public ResponseEntity<?> cadastrar(@RequestBody CadastroRequest cadastroRequest) {

            // Verifica se o CPF já está cadastrado
            System.out.println(usuarioService.validarUserAccount(cadastroRequest.cpf));

            if (usuarioService.validarUserAccount(cadastroRequest.cpf) != null) {
                return ResponseEntity.badRequest().body("{\"message\": \"CPF já cadastrado.\"}");
            }

            Usuario newUser = new Usuario();
            newUser.setCpf(cadastroRequest.cpf);
            newUser.setNome(cadastroRequest.nome);
            newUser.setSenha(cadastroRequest.senha);

            Usuario userCadastro = usuarioService.criarUsuario(newUser);

            return ResponseEntity.ok(userCadastro);
        }

        public static class CadastroRequest {
            public String nome;
            public Long cpf;
            public String senha;
        }



    }

