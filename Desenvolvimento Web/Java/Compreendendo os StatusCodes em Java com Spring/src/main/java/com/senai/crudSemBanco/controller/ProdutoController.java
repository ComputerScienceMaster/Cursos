package com.senai.crudSemBanco.controller;

import com.senai.crudSemBanco.banco.BancoDeProdutos;
import com.senai.crudSemBanco.model.Produto;

import java.util.List;

public class ProdutoController {

    BancoDeProdutos bc = new BancoDeProdutos();

    public void inserirNoBanco(Produto p) {
        bc.insert(p);
    }

    public List<Produto> pegarTodosOsProdutos() {
        return bc.findAll();
    }
}
