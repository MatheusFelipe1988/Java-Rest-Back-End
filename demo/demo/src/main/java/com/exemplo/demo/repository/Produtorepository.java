package com.exemplo.demo.repository;

import com.exemplo.demo.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Produtorepository extends CrudRepository<Produto, String> {
}
