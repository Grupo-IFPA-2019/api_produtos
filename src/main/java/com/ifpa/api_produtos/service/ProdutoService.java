package com.ifpa.api_produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifpa.api_produtos.model.Produto;
import com.ifpa.api_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto) {
        boolean produtoExist = produtoRepository.findByNomeProduto(produto.getNomeProduto())
        .stream()
        .anyMatch(produtoExistente -> !produtoExistente.equals(produto));

        return produtoRepository.save(produto);
    }

    @Transactional
    public void excluir(Long clienteId) {
        produtoRepository.deleteById(clienteId);
    }
}
