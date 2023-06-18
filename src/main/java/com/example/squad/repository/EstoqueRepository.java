package com.example.squad.repository;

import com.example.squad.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    // implementar ainda 
    // List<Estoque> findByCategoria(String categoria);
}
