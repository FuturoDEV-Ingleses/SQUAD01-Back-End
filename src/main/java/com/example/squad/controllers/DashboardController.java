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
    private int totalAnimais; // Adicionando a variável para o total de animais

    public DashboardController(EstoqueService estoqueService, ArmazemService armazemService, int totalAnimais) {
        this.estoqueService = estoqueService;
        this.armazemService = armazemService;
        this.totalAnimais = totalAnimais;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        
        int quantidadeRacaoEstoqueCachorroFilhotes = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Ração", "Filhotes");
        int quantidadeRacaoEstoqueCachorroAdultos = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Ração", "Adultos");
        int quantidadeRacaoEstoqueGatoFilhotes = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Ração", "Filhotes");
        int quantidadeRacaoEstoqueGatoAdultos = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Ração", "Adultos");
        int quantidadeAntiparasitariaEstoqueCachorroFilhotes = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Antiparasitária", "Filhotes");
        int quantidadeAntiparasitariaEstoqueCachorroAdultos = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Antiparasitária", "Adultos");
        int quantidadeAntiparasitariaEstoqueGatoFilhotes = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Antiparasitária", "Filhotes");
        int quantidadeAntiparasitariaEstoqueGatoAdultos = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Antiparasitária", "Adultos");
        int quantidadeAntipulgasEstoqueCachorroFilhotes = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Antipulgas", "Filhotes");
        int quantidadeAntipulgasEstoqueCachorroAdultos = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Cachorro", "Antipulgas", "Adultos");
        int quantidadeAntipulgasEstoqueGatoFilhotes = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Antipulgas", "Filhotes");
        int quantidadeAntipulgasEstoqueGatoAdultos = estoqueService.getQuantidadeProdutoPorAnimalCategoria("Gato", "Antipulgas", "Adultos");

        List<Armazem> armazens = armazemService.buscarTodos();
        
        double valorTotalArmazens = calcularValorTotalArmazens(armazens);

        model.addAttribute("quantidadeRacaoEstoqueCachorroFilhotes", quantidadeRacaoEstoqueCachorroFilhotes);
        model.addAttribute("quantidadeRacaoEstoqueCachorroAdultos", quantidadeRacaoEstoqueCachorroAdultos);
        model.addAttribute("quantidadeRacaoEstoqueGatoFilhotes", quantidadeRacaoEstoqueGatoFilhotes);
        model.addAttribute("quantidadeRacaoEstoqueGatoAdultos", quantidadeRacaoEstoqueGatoAdultos);
        model.addAttribute("quantidadeAntiparasitariaEstoqueCachorroFilhotes", quantidadeAntiparasitariaEstoqueCachorroFilhotes);
        model.addAttribute("quantidadeAntiparasitariaEstoqueCachorroAdultos", quantidadeAntiparasitariaEstoqueCachorroAdultos);
        model.addAttribute("quantidadeAntiparasitariaEstoqueGatoFilhotes", quantidadeAntiparasitariaEstoqueGatoFilhotes);
        model.addAttribute("quantidadeAntiparasitariaEstoqueGatoAdultos", quantidadeAntiparasitariaEstoqueGatoAdultos);
        model.addAttribute("quantidadeAntipulgasEstoqueCachorroFilhotes", quantidadeAntipulgasEstoqueCachorroFilhotes);
        model.addAttribute("quantidadeAntipulgasEstoqueCachorroAdultos", quantidadeAntipulgasEstoqueCachorroAdultos);
        model.addAttribute("quantidadeAntipulgasEstoqueGatoFilhotes", quantidadeAntipulgasEstoqueGatoFilhotes);
        model.addAttribute("quantidadeAntipulgasEstoqueGatoAdultos", quantidadeAntipulgasEstoqueGatoAdultos);
        model.addAttribute("valorTotalArmazens", valorTotalArmazens);
        model.addAttribute("totalAnimais", totalAnimais);

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
