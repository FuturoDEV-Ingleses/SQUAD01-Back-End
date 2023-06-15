package com.example.squad.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmazemServiceImpl implements ArmazemService {


    @Override
    public Armazem salvar(Armazem armazem) throws Exception {
        return null;
    }

    @Override
    public List<Armazem> buscarTodos() {
        return null;
    }

    @Override
    public Armazem buscarPorId(Long id) throws Exception {
        return null;
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        return false;
    }
}
