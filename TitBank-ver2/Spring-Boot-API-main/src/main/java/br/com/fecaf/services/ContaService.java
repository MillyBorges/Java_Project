package br.com.fecaf.services;

import br.com.fecaf.model.Conta;
import br.com.fecaf.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }
}
