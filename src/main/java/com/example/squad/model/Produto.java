package com.example.squad.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String produto;

    @Column(length = 20, nullable = false)
    private String animal;

    @Column(length = 20, nullable = false)
    private String categoria;

    @Column(length = 20, nullable = false)
    private String armazenamento;

    @Column(length = 10, nullable = false)
    private String quantidade;


}
