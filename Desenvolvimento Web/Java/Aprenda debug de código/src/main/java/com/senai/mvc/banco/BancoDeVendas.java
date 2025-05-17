package com.senai.mvc.banco;

import com.senai.mvc.model.Cliente;
import com.senai.mvc.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class BancoDeVendas {
    private List<Venda> venda;

    public BancoDeVendas() {
        this.venda = new ArrayList<>();
    }

    // Insere um novo produto na lista
    public void insert(Venda p) {
        venda.add(p);
    }

    // Busca um produto pelo ID
    public Venda findOne(int id) {
        for (Venda p : venda) {
            if (p.getIdVenda() == id) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Retorna todos os produtos cadastrados
    public List<Venda> findAll() {
        return new ArrayList<>(venda);
    }

    // Atualiza um produto existente na lista
    public boolean update(Venda p) {
        for (int i = 0; i < venda.size(); i++) {
            if (venda.get(i).getIdVenda() == p.getIdVenda()) {
                venda.set(i, p);
                return true; // Retorno indicando que a atualização foi feita
            }
        }
        return false; // Retorna falso se o produto não foi encontrado
    }

    // Remove um produto pelo ID
    public boolean delete(int id) {
        return venda.removeIf(p -> p.getIdVenda() == id);
    }
}
