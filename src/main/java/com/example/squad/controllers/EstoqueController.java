package com.example.squad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.squad.model.Estoque;
import com.example.squad.service.EstoqueService;
import java.util.List;

@Controller
public class EstoqueController {
    private EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping("/estoque")
    public String showEstoque(Model model) {
        List<Estoque> estoque = estoqueService.buscarTodos();
        model.addAttribute("estoque", estoque);
        return "estoque";
    }
}

