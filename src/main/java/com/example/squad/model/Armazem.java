package com.example.squad.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String animal;

    @Column(nullable = false)
    private String situacao = "Ativo"; // Valor padrão "ativo"

}
