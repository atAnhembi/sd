package br.anhembi.spring02.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.Produto;
import br.anhembi.spring02.repository.ProdutoRepo;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepo repo;

    public Optional<Produto> getProduto(long cod) {
        return repo.findById(cod);
    }

}
