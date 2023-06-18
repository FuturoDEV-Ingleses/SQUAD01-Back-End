package com.example.squad.service;

import com.example.squad.model.Produto;
import com.example.squad.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(Produto produto) throws Exception {
        if (produto.getId() != null) {
            buscarPorId(produto.getId());
        }

        if (produto.getProduto() == null || produto.getProduto().isEmpty()) {
            throw new Exception("Produto é obrigatório");
        }
        if (produto.getCategoria() == null || produto.getCategoria().isEmpty()) {
            throw new Exception("Categoria é obrigatório");
        }

        if (produto.getQuantidade() == null || produto.getQuantidade().isEmpty()) {
            throw new Exception("Quantidade é obrigatório");
        }
        if (produto.getAnimal() == null || produto.getAnimal().isEmpty()) {
            throw new Exception("Animal é obrigatório");
        }
        if (produto.getArmazenamento() == null || produto.getArmazenamento().isEmpty()) {
            throw new Exception("Armazenamento é obrigatório");
        }

        produto = produtoRepository.save(produto);
        return produto;
    }

    @Override
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id) throws Exception {
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("Produto não encontrado!");
        }
        return opt.get();
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        Produto produto = buscarPorId(id);
        try {
            produtoRepository.delete(produto);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
