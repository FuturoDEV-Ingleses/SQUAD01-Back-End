package com.example.squad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboarController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        // Lógica para exibir o dashboard
        return "dashboard";
    }
}
