package com.desafio.produtosapi.repository;

import io.github.cursodsousa.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository ProdutoRepository extends JpaRepository<Produto, String>{
    List<Produto> findByNome(String nome);
}
