package com.senai.mvc.banco;

import java.util.ArrayList;
import java.util.List;
import com.senai.mvc.model.Produto;

public class BancoDeProdutos {
    private List<Produto> produtos;

    public BancoDeProdutos() {
        this.produtos = new ArrayList<>();
    }

    // Insere um novo produto na lista
    public void insert(Produto p) {
        produtos.add(p);
    }

    // Busca um produto pelo ID
    public Produto findOne(int id) {
        for (Produto p : produtos) {
            if (p.getIdProduto() == id) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Retorna todos os produtos cadastrados
    public List<Produto> findAll() {
        return new ArrayList<>(produtos);
    }

    // Atualiza um produto existente na lista
    public boolean update(Produto p) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getIdProduto() == p.getIdProduto()) {
                produtos.set(i, p);
                return true; // Retorno indicando que a atualização foi feita
            }
        }
        return false; // Retorna falso se o produto não foi encontrado
    }

    // Remove um produto pelo ID
    public boolean delete(int id) {
        return produtos.removeIf(p -> p.getIdProduto() == id);
    }
}
