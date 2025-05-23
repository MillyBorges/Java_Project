package br.com.fecaf.controller;

import br.com.fecaf.model.Usuario;
import br.com.fecaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Usuario usuarioOptional = usuarioService.realizarLogin(loginRequest.cpf, loginRequest.senha);

        if (usuarioOptional.isPresent() && usuarioOptional.getSenha().equals(loginRequest.senha)) {
            return ResponseEntity.ok(usuarioOptional);
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }


    public static class LoginRequest {
        public Long cpf;
        public String senha;
    }
}
