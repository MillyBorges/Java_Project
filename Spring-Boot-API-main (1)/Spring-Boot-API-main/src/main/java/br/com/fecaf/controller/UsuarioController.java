package br.com.fecaf.controller;


import br.com.fecaf.model.Usuario;
import br.com.fecaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario>criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario>buscarUsuario(@PathVariable String cpf) {
        Usuario usuario = usuarioService.buscarPorCpf(cpf);
        return ResponseEntity.ok(usuario);
    }


}
