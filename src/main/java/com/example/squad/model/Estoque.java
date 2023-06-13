package com.example.squad.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String armazenado;

    @Column(length = 20, nullable = false)
    private String produto;

    @Column(length = 10, nullable = false)
    private String quantidade;

    @Column(length = 20, nullable = false)
    private String categoria;
}
