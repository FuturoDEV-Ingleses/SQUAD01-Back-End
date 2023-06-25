package com.example.squad.controllers;

import com.example.squad.model.Usuario;
import com.example.squad.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<Boolean> login(@RequestBody Usuario usuario) {
        boolean authenticated = usuarioService.authenticate(usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.status(authenticated ? HttpStatus.OK : HttpStatus.UNAUTHORIZED).body(authenticated);
    }
}
