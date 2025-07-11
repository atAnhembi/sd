package br.anhembi.spring02.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring02.model.Produto;

// CRUD = Create, Read, Update, Delete
public interface ProdutoRepo extends CrudRepository<Produto, Long> {
    // JPA Query Methods
    List<Produto> findByNameContains(String name);  
}
