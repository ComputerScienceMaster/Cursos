package com.senai.crudSemBanco.model;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private String descricao;
    private double preco;
    private int quantidade;
    private String pontoDeVenda;

    // Construtor
    public Produto(int idProduto, String nomeProduto, String descricao, double preco, int quantidade, String pontoDeVenda) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.pontoDeVenda = pontoDeVenda;
    }

    // Getters e Setters
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPontoDeVenda() {
        return pontoDeVenda;
    }

    public void setPontoDeVenda(String pontoDeVenda) {
        this.pontoDeVenda = pontoDeVenda;
    }

    // Método para exibir informações do produto
    public void exibirInformacoes() {
        System.out.println("ID: " + idProduto);
        System.out.println("Nome: " + nomeProduto);
        System.out.println("Descrição: " + descricao);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Ponto de Venda: " + pontoDeVenda);
    }
}
