package br.com.fecaf.controller;

import br.com.fecaf.services.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chavePix")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PixController {

    @Autowired
    private PixService pixService;

    @PostMapping("/pix")
    public String enviarPix(@RequestBody SetPix setPix ) {
        return pixService.enviarPix(setPix.chavePix, setPix.valor);
    }

    public static class SetPix {
        public String chavePix;
        public Double valor;
    }
}