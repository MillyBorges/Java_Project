package br.com.fecaf.controller;


import br.com.fecaf.model.Usuario;
import br.com.fecaf.repository.UsuarioRepository;
import br.com.fecaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class UsuarioController {


//    private final UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;


    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/api/login")
    public ResponseEntity<Usuario> realizarLogin (@RequestBody long cpf, String password){
        System.out.println(cpf + "  " + password);

        Usuario user = usuarioService.realizarLogin(cpf, password);

        if (user != null){
//            return user;
            ResponseEntity.ok(user);
        }

        ResponseEntity.notFound();

        return null;
    }



    @PostMapping("/api/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
}
