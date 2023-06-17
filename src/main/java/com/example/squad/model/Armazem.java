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
    @JoinColumn(nullable = false)
    private Armazem nome;

    @JoinColumn(nullable = false)
    private Armazem animal;




}
