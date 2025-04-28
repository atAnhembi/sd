package br.anhembi.spring02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.Produto;
import br.anhembi.spring02.repository.ProdutoRepo;

@Service
public class ProdutoService {
    
    @Autowired // injeção de dependência
    private ProdutoRepo repo;

    public Optional<Produto> getProduto(long cod) {
        return repo.findById(cod);
    }

    public Produto create(Produto produto) {
        return repo.save(produto);
    }

    public Produto update(Produto produto) {
        return repo.save(produto);
    }

    public boolean delete(long cod) {
        Optional<Produto> optional = repo.findById(cod);
        if(optional.isPresent()) {
            repo.deleteById(cod);
            return true;
        }
        return false;
    }

    public List<Produto> getAll() {
        return (List<Produto>) repo.findAll();
    }

    public List<Produto> findByName(String name) {
        return repo.findByNameContains(name);
    }
}
