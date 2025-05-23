package br.com.fecaf.controller;

import br.com.fecaf.services.PixService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chaves_pix")
public class PixController {
    private final PixService pixService;

    public PixController(PixService pixService) {
        this.pixService = pixService;
    }

    @PostMapping
    public String enviarPix(@RequestParam String chavePix, @RequestParam Double valor) {
        return pixService.enviarPix(chavePix, valor);
    }
}