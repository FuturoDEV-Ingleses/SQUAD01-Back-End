package com.example.squad.controllers;

import com.example.squad.model.Armazem;
import com.example.squad.repository.ArmazemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armazem")
public class ArmazemController {

    private final ArmazemRepository armazemRepository;

    @Autowired
    public ArmazemController(ArmazemRepository armazemRepository) {
        this.armazemRepository = armazemRepository;
    }

    @GetMapping
    public List<Armazem> fetchArmazemList() {
        return armazemRepository.findAll();
    }

    @PostMapping
    public Armazem saveArmazem(@RequestBody Armazem armazem) {
        armazem.setSituacao("Ativo"); // Define o valor padrão "ativo" para a coluna "situacao"
        return armazemRepository.save(armazem);
    }

    @PutMapping("/{id}")
    public Armazem updateArmazem(@PathVariable Long id, @RequestBody Armazem updatedArmazem) {
        Armazem armazem = armazemRepository.findById(id).orElse(null);
        if (armazem != null) {
            armazem.setNome(updatedArmazem.getNome());
            armazem.setAnimal(updatedArmazem.getAnimal());
            armazem.setSituacao(updatedArmazem.getSituacao());
            return armazemRepository.save(armazem);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteArmazem(@PathVariable Long id) {
        armazemRepository.deleteById(id);
    }
}
