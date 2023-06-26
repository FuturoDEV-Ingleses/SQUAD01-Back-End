package com.example.squad.controllers;

import com.example.squad.model.Estoque;
import com.example.squad.service.EstoqueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;



import java.util.List;



@Controller
public class EstoqueController {
    private EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping("/estoque")
    public String showEstoque(Model model) {
        // Obter lista de itens do estoque
        List<Estoque> itensEstoque = estoqueService.buscarTodos();

        // Adicionar lista ao modelo para exibição no frontend
        model.addAttribute("itensEstoque", itensEstoque);

        return "estoque";
    }

    @PostMapping("/estoque")
    public String salvarEstoque(@ModelAttribute Estoque estoque) {
        try {
            estoqueService.salvar(estoque);
        } catch (Exception e) {
            
            return "erro";
        }

        return "redirect:/estoque";
    }

    @GetMapping("/estoque/editar/{id}")
    public String editarEstoque(@PathVariable Long id, Model model) {
        try {
            Estoque estoque = estoqueService.buscarPorId(id);
            model.addAttribute("estoque", estoque);
            return "editar-estoque";
        } catch (Exception e) {
            
            return "erro";
        }
    }

    @PostMapping("/estoque/editar/{id}")
    public String atualizarEstoque(@PathVariable Long id, @ModelAttribute Estoque estoque) {
        try {
            Estoque estoqueExistente = estoqueService.buscarPorId(id);
            // Atualizar apenas os campos permitidos
            estoqueExistente.setProduto(estoque.getProduto());
            estoqueExistente.setQuantidade(estoque.getQuantidade());
            estoqueService.salvar(estoqueExistente);
            return "redirect:/estoque";
        } catch (Exception e) {
            // Tratar item de estoque não encontrado ou outra exceção
            return "erro";
        }
    }

    @GetMapping("/estoque/remover/{id}")
    public String removerEstoque(@PathVariable Long id) {
        try {
            estoqueService.apagar(id);
            return "redirect:/estoque";
        } catch (Exception e) {
            // Tratar item de estoque não encontrado ou outra exceção
            return "erro";
        }
    }
}
