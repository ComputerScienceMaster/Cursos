package com.senai.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    private Integer idVenda;
    private LocalDate dataDaVenda;
    private ArrayList<Produto> produto;
    private Cliente cliente;
}
