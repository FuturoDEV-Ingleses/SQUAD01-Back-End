package com.example.squad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.squad.service.EstoqueService;
import com.example.squad.service.ArmazemService;
import com.example.squad.model.Armazem;

import java.util.List;

@Controller
public class DashboardController {
    private EstoqueService estoqueService;
    private ArmazemService armazemService;

    public DashboardController(EstoqueService estoqueService, ArmazemService armazemService) {
        this.estoqueService = estoqueService;
        this.armazemService = armazemService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Obter informações do Estoque
        int quantidadeRacaoEstoqueCachorro = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Ração");
        int quantidadeRacaoEstoqueGato = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Ração");
        int quantidadeAntiparasitariaEstoqueCachorro = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Antiparasitária");
        int quantidadeAntiparasitariaEstoqueGato = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Antiparasitária");
        int quantidadeAntipulgasEstoqueCachorro = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Antipulgas");
        int quantidadeAntipulgasEstoqueGato = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Antipulgas");

        // Obter informações dos Armazéns
        List<Armazem> armazens = armazemService.buscarTodos();

        // Calcular valor total dos itens nos Armazéns
        double valorTotalArmazens = calcularValorTotalArmazens(armazens);

        // Adicionar os dados ao modelo para serem exibidos no frontend
        model.addAttribute("quantidadeRacaoEstoqueCachorro", quantidadeRacaoEstoqueCachorro);
        model.addAttribute("quantidadeRacaoEstoqueGato", quantidadeRacaoEstoqueGato);
        model.addAttribute("quantidadeAntiparasitariaEstoqueCachorro", quantidadeAntiparasitariaEstoqueCachorro);
        model.addAttribute("quantidadeAntiparasitariaEstoqueGato", quantidadeAntiparasitariaEstoqueGato);
        model.addAttribute("quantidadeAntipulgasEstoqueCachorro", quantidadeAntipulgasEstoqueCachorro);
        model.addAttribute("quantidadeAntipulgasEstoqueGato", quantidadeAntipulgasEstoqueGato);
        model.addAttribute("valorTotalArmazens", valorTotalArmazens);

        return "dashboard";
    }

   private double calcularValorTotalArmazens(List<Armazem> armazens) {
    double valorTotal = 0.0;
    for (Armazem armazem : armazens) {
        valorTotal += armazem.getValor(); 
    }
    return valorTotal;
}
    }

