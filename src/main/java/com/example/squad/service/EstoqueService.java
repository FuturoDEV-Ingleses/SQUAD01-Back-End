package com.example.squad.service;

import com.example.squad.model.Estoque;
import java.util.List;

public interface EstoqueService {

    Estoque salvar(Estoque estoque) throws Exception;

    List<Estoque> buscarTodos();

    Estoque buscarPorId(Long id) throws Exception;

    boolean apagar(Long id) throws Exception;

    int getQuantidadeProdutoPorAnimalCategoria(String animal, String categoria);
}
