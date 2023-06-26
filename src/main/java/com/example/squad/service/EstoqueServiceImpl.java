package com.example.squad.service;

import com.example.squad.model.Estoque;
import com.example.squad.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public Estoque salvar(Estoque estoque) throws Exception {
        if (estoque.getId() != null) {
            // Verificar se o ID já existe no banco de dados
            if (estoqueRepository.existsById(estoque.getId())) {
                throw new Exception("ID do item de estoque já existe!");
            }
        }

        estoque = estoqueRepository.save(estoque);
        return estoque;
    }

    @Override
    public List<Estoque> buscarTodos() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque buscarPorId(Long id) throws Exception {
        Optional<Estoque> opt = estoqueRepository.findById(id);
        if (!opt.isPresent()) {
            throw new Exception("Item de estoque não encontrado!");
        }
        return opt.get();
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        Estoque estoque = buscarPorId(id);
        try {
            estoqueRepository.delete(estoque);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int getQuantidadeProdutoPorAnimalCategoria(String animal, String categoria) {
        return 0;
    }
}
