package com.example.squad.service;

import java.util.List;

public interface ArmazemService {

    Armazem salvar(Armazem armazem) throws Exception;

    List<Armazem> buscarTodos ();

    Armazem buscarPorId(Long id) throws Exception;

    boolean apagar(Long id) throws Exception;


}
