package com.example.squad.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String animal;




}
