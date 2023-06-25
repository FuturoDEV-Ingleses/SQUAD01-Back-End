package com.example.squad.service;

import com.example.squad.model.Estoque;
import com.example.squad.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public Estoque salvar(Estoque estoque) throws Exception {
        if (estoque.getId() != null) {
            // Verificar se o ID já existe no banco de dados
            if (estoqueRepository.existsById(estoque.getId())) {
                throw new Exception("ID do item de estoque já existe!");
            }
        }

        estoque = estoqueRepository.save(estoque);
        return estoque;
    }

    @Override
    public List<Estoque> buscarTodos() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque buscarPorId(Long id) throws Exception {
        Optional<Estoque> opt = estoqueRepository.findById(id);
        if (!opt.isPresent()) {
            throw new Exception("Item de estoque não encontrado!");
        }
        return opt.get();
    }

    @Override
    public boolean apagar(Long id) throws Exception {
        Estoque estoque = buscarPorId(id);
        try {
            estoqueRepository.delete(estoque);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int getQuantidadeProdutoPorAnimalCategoria(String animal, String categoria) {
       
        throw new UnsupportedOperationException("Unimplemented method 'getQuantidadeProdutoPorAnimalCategoria'");
    }

    @Override
public Estoque atualizarProduto(Long id, String novoNomeProduto, String novaQuantidade) throws Exception {
    Estoque estoque = buscarPorId(id);
    estoque.setProduto(novoNomeProduto);
    estoque.setQuantidade(novaQuantidade);
    estoque = estoqueRepository.save(estoque);
    return estoque;
}

@Override
public Estoque cadastrarNovoProduto(String armazenado, String produto, String quantidade, String animal, String categoria) throws Exception {
    
    Estoque estoque = new Estoque();
    estoque.setArmazenado(armazenado);
    estoque.setProduto(produto);
    estoque.setQuantidade(quantidade);
    estoque.setAnimal(animal);
    estoque.setCategoria(categoria);

    estoque = estoqueRepository.save(estoque);
    return estoque;
}


}  

 // Implementação de métodos personalizados, se necessário

//package com.example.squad.service;
//
//import com.example.squad.model.Produto;
//import com.example.squad.repository.ProdutoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EstoqueServiceImpl implements ProdutoService {
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    @Override
//    public Produto salvar(Produto produto) throws Exception {
//        if (produto.getId() != null) {
//            buscarPorId(produto.getId());
//        }
//
//        if (produto.getProduto() == null || produto.getProduto().isEmpty()) {
//            throw new Exception("Produto é obrigatório");
//        }
//        if (produto.getCategoria() == null || produto.getCategoria().isEmpty()) {
//            throw new Exception("Categoria é obrigatório");
//        }
//
//        if (produto.getQuantidade() == null || produto.getQuantidade().isEmpty()) {
//            throw new Exception("Quantidade é obrigatório");
//        }
//        if (produto.getAnimal() == null || produto.getAnimal().isEmpty()) {
//            throw new Exception("Animal é obrigatório");
//        }
//        if (produto.getArmazenamento() == null || produto.getArmazenamento().isEmpty()) {
//            throw new Exception("Armazenamento é obrigatório");
//        }
//
//        produto = produtoRepository.save(produto);
//        return produto;
//    }
//
//    @Override
//    public List<Produto> buscarTodos() {
//        return produtoRepository.findAll();
//    }
//
//    @Override
//    public Produto buscarPorId(Long id) throws Exception {
//        Optional<Produto> opt = produtoRepository.findById(id);
//        if (opt.isEmpty()) {
//            throw new Exception("Produto não encontrado!");
//        }
//        return opt.get();
//    }
//
//    @Override
//    public boolean apagar(Long id) throws Exception {
//        Produto produto = buscarPorId(id);
//        try {
//            produtoRepository.delete(produto);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//}
