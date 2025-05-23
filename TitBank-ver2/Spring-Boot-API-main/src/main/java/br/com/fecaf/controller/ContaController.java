package br.com.fecaf.controller;

import br.com.fecaf.model.Conta;
import br.com.fecaf.services.ContaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public List<Conta> listarContas() {
        return contaService.listarContas();
    }
}