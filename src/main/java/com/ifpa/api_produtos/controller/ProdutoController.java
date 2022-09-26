package com.ifpa.api_produtos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ifpa.api_produtos.model.Produto;
import com.ifpa.api_produtos.repository.ProdutoRepository;
import com.ifpa.api_produtos.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> buscar(@PathVariable Long produtoId){
        return produtoRepository.findById(produtoId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    } 
     

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar (@Valid @RequestBody  Produto produto){
        return produtoService.salvar(produto);
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<Produto> atualizar (@PathVariable Long produtoId, @Valid @RequestBody  Produto produto){
        if(!produtoRepository.existsById(produtoId)){
            return ResponseEntity.notFound().build();
        }
        produto.setId(produtoId);
        produto = produtoService.salvar(produto);

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deletar (@PathVariable Long produtoId){
        if(!produtoRepository.existsById(produtoId)){
            return ResponseEntity.notFound().build();
        }
        produtoService.excluir(produtoId);
        return ResponseEntity.noContent().build();
    }
}
