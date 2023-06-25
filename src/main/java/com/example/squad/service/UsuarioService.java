package com.example.squad.service;

import com.example.squad.model.Usuario;
import com.example.squad.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) throws IllegalArgumentException {

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("A senha do usuário é obrigatória.");
        }

        // Verificar se o e-mail já está cadastrado
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new IllegalArgumentException("O e-mail já está cadastrado.");
        }

        return usuarioRepository.save(usuario);
    }

}
