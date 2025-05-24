package br.com.fecaf.services;

import br.com.fecaf.model.Conta;
import br.com.fecaf.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> findById(int id){
        return contaRepository.findById(id);
    }
}
