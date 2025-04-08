package br.anhembi.spring02.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring02.model.Produto;
import br.anhembi.spring02.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    
    @GetMapping("/{cod}")
    public ResponseEntity<Produto> getProduto(@PathVariable long cod) {
        Optional<Produto> optionalProd = service.getProduto(cod);

        if(optionalProd.isPresent()) {
            return ResponseEntity.ok(optionalProd.get());
        }
        return ResponseEntity.notFound().build();
    }
}
