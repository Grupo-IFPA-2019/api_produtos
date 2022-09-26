package com.ifpa.api_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpa.api_produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    //busca por nome
    List<Produto> findByNomeProduto(String nomeProduto);
}
