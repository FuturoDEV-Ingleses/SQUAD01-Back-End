package com.example.squad.repository;

import com.example.squad.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query("SELECT SUM(e.quantidade) FROM Estoque e WHERE e.animal = ?1 AND e.categoria = ?2 AND e.estagio = ?3")
    int getQuantidadeProdutoPorAnimalCategoria(String animal, String categoria, String estagio);

}
