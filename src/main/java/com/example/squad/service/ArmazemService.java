package com.example.squad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.squad.model.Armazem;
import com.example.squad.repository.ArmazemRepository;


@Service
public class ArmazemService {

    private final ArmazemRepository armazemRepository;

    @Autowired
    public ArmazemService(ArmazemRepository armazemRepository) {
        this.armazemRepository = armazemRepository;

    }

    public Armazem saveArmazem(Armazem armazem) {
        return armazemRepository.save(armazem);
    }
}
