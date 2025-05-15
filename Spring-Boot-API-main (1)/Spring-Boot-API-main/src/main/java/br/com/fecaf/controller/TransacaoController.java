package br.com.fecaf.controller;

import br.com.fecaf.model.Transacoes;
import br.com.fecaf.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService trasacaoService;

    @PostMapping
    public ResponseEntity<Transacoes>realizarTransacao(@RequestBody Transacoes transacoes){
        Transacoes novaTrasacao = trasacaoService.realizarTransacao(transacoes);
        return new ResponseEntity<>(novaTrasacao, HttpStatus.CREATED);
    }

}
