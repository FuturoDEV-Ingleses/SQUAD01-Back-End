package com.example.squad.service;

import com.example.squad.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto salvar(Produto produto) throws Exception;

    // Read - GET
    List<Produto> buscarTodos();

    // Read - GET
    Produto buscarPorId(Long id) throws Exception;

    // Delete - DELETE
    boolean apagar(Long id) throws Exception;

}
