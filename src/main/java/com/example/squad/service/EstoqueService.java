package com.example.squad.service;

import com.example.squad.model.Estoque;
import java.util.List;

public interface EstoqueService {

    Estoque salvar(Estoque estoque) throws Exception;

    List<Estoque> buscarTodos();

    Estoque buscarPorId(Long id) throws Exception;

    boolean apagar(Long id) throws Exception;

    int getQuantidadeProdutoPorAnimalCategoria(String animal, String categoria);

    public Estoque atualizarProduto(Long id, String novoNomeProduto, String novaQuantidade) throws Exception;
   
    Estoque cadastrarNovoProduto(String armazenado, String produto, String quantidade, String animal, String categoria) throws Exception;

}
