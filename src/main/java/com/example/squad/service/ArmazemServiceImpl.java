package com.example.squad.service;

import com.example.squad.model.Armazem;
import com.example.squad.repository.ArmazemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmazemServiceImpl implements ArmazemService {

    @Autowired
    private ArmazemRepository armazemRepository;

    @Override
    public Armazem salvar(Armazem armazem) throws Exception {
        if (armazem.getId() != null) {
           
            if (armazemRepository.existsById(armazem.getId())) {
                throw new Exception("ID do armazém já existe!");
            }
        }

        if (armazem.getNome() == null || armazem.getNome().isEmpty()) {
            throw new Exception("Nome do armazém é obrigatório");
        }

        armazem = armazemRepository.save(armazem);
        return armazem;
    }

    @Override
    public List<Armazem> buscarTodos() {
        return armazemRepository.findAll();
    }

    @Override
    public Armazem buscarPorId(Long id) throws Exception {
        Optional<Armazem> opt = armazemRepository.findById(id);
        if (!opt.isPresent()) {
            throw new Exception("Armazém não encontrado!");
        }
        return opt.get();
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        Armazem armazem = buscarPorId(id);
        try {
            armazemRepository.delete(armazem);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
