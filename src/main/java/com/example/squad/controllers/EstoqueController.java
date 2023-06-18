package com.example.squad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstoqueController {

    @GetMapping("/estoque")
    public String showEstoque() {
        // Lógica para exibir o estoque
        return "estoque";
    }
}
