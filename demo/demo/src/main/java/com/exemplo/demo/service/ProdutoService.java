package com.exemplo.demo.service;

import com.exemplo.demo.domain.Produto;
import com.exemplo.demo.repository.Produtorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private Produtorepository repository;
    public List<Produto> listarTodes(){
        return (List<Produto>)repository.findAll();
    }
    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Optional<Produto> buscaPorId(String sku) {
        return Optional.of(repository.findById(sku).get());
    }

    public void delete(String sku) {
        repository.deleteById(sku);
    }
}
