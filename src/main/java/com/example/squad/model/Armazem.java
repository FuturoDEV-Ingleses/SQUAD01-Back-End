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

    private double valor;

     public double getValor() {
        return valor;
    }
     public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

     @Override
    public String toString() {
        return "Armazem [id=" + id + ", nome=" + nome + ", animal=" + animal + ", situacao=" + situacao + ", valor=" + valor + "]";
   
    }


}
