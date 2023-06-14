package com.example.squad.controllers;

import com.example.squad.model.Armazem;
import com.example.squad.repository.ArmazemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
* Armazem controller aqui sera criado todos os endpoints relacionado ao armazem!
* Rota /armazem lista todos os dados da tabela armazem
* */
@RestController
@RequestMapping("/armazem")
public class ArmazemController {

    @Autowired
    private ArmazemRepository armazemRepository;

    @GetMapping
    public List<Armazem> obterTodosArmazens() {
        return armazemRepository.findAll();
    }
}
