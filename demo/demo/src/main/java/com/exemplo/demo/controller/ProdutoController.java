package com.exemplo.demo.controller;

import com.exemplo.demo.domain.Produto;
import com.exemplo.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    @GetMapping
    public ResponseEntity<List<Produto>>listarTodes(){
       List<Produto> produtos = service.listarTodes();
       return ResponseEntity.ok(produtos);
    }
    @GetMapping("/{sku}")
    public ResponseEntity<Produto> BuscaPorId(@PathVariable String sku){
        Optional<Produto> optProduto = service.buscaPorId(sku);
        if (optProduto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optProduto.get());
    }
    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        Produto novoProduto = service.salvar(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Produto> alterar(@RequestBody Produto produto){
        Produto produtoAlterado = service.salvar(produto);
        return ResponseEntity.ok(produtoAlterado);
    }
    @DeleteMapping("/{sku}")
    public ResponseEntity<Void>delete(@PathVariable String sku) {
        service.delete(sku);
        return ResponseEntity.noContent().build();
    }
}

