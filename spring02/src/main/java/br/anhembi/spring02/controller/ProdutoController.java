package br.anhembi.spring02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

        if (optionalProd.isPresent()) {
            return ResponseEntity.ok(optionalProd.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Produto>> getProdutoByName(@PathVariable String name) {
        List<Produto> produtos = service.findByName(name);

        return ResponseEntity.ok(produtos);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProduto() {
        List<Produto> produtos = service.getAll();

        if (produtos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos);
    }

    // @RequestBody indica que o parâmetro virá no corpo da requisição
    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto newProduto) {
        if (newProduto.getCod() != null) {
            return ResponseEntity.badRequest().build();
        }
        Produto produtoInserido = service.create(newProduto);

        return ResponseEntity.ok(produtoInserido);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto newProduto) {
        if (newProduto.getCod() == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Produto> optionalProd = service.getProduto(newProduto.getCod());

        if (optionalProd.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Produto produtoInserido = service.update(newProduto);

        return ResponseEntity.ok(produtoInserido);
    }

    @DeleteMapping("/{cod}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable long cod) {
        boolean apagado = service.delete(cod);

        if (apagado) {
            return ResponseEntity.noContent().build(); // sucesso, sem conteúdo
        }
        return ResponseEntity.notFound().build();
    }
}
