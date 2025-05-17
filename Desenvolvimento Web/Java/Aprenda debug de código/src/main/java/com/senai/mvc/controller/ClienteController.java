package com.senai.mvc.controller;

import com.senai.mvc.banco.BancoDeClientes;
import com.senai.mvc.model.Cliente;

import java.util.List;

public class ClienteController {

    BancoDeClientes bc = new BancoDeClientes();
    public List<Cliente> getAllClientes() {
        return bc.findAll();
    }

    public Boolean save(Cliente c) {
        bc.insert(c);
        return true;
    }
}
