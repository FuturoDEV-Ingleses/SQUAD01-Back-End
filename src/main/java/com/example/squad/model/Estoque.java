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

    @Column(length = 20, nullable = false)
    private String animal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArmazenado() {
        return armazenado;
    }

    public void setArmazenado(String armazenado) {
        this.armazenado = armazenado;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
