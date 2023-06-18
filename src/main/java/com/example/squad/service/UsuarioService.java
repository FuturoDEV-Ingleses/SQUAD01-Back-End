package com.example.squad.service;

public class UsuarioService {

        public void CriarUsuario(String nome, String email, String senha) {

            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("O nome do usuário é obrigatório.");
            }

            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("O e-mail do usuário é obrigatório.");
            }

            if (senha == null || senha.isEmpty()) {
                throw new IllegalArgumentException("A senha do usuário é obrigatória.");
            }


            new Usuario(nome, email, senha);


            System.out.println("Usuário criado com sucesso!");
        }
    }




