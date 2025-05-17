package com.senai.mvc.controller;

import com.senai.mvc.banco.BancoDeClientes;
import com.senai.mvc.banco.BancoDeProdutos;
import com.senai.mvc.banco.BancoDeVendas;
import com.senai.mvc.model.Cliente;
import com.senai.mvc.model.Produto;
import com.senai.mvc.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaController {

    BancoDeVendas bcoVendas = new BancoDeVendas();
    BancoDeClientes bcoClientes = new BancoDeClientes();
    BancoDeProdutos bcoProdutos = new BancoDeProdutos();

    public List<Venda> getAllVendas() {
        return bcoVendas.findAll();
    }

    public Boolean save(Venda v) {
        List<Cliente> clientesCadastrados = bcoClientes.findAll();
        List<Produto> produtosCadastrados = bcoProdutos.findAll();

        Cliente clienteEnviado = v.getCliente();
        List<Produto> produtosEnviados = v.getProduto();

        // verifica se o cliente está dentro da lista
        if (bcoClientes.findOne(clienteEnviado.getIdCliente()) == null){
            return false;
        }

        // verifica se os produtos enviados estão dentro da lista
        for (Produto p : produtosEnviados){
            if (bcoProdutos.findOne(p.getIdProduto()) == null){
                return false;
            }
        }

        bcoVendas.insert(v);
        return true;
    }
}
