/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Thiago
 */
public class Produto {

    private String nome;
    private double valor;
    private String detalhes;
    private Tipo tipo;
    private Promocao promo;
    private Cooperador fornecedor;
    private String imagem; 
    private int id;
    private int quantidade;
    private ProdutoPadrao produtoPadrao;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    

    public ProdutoPadrao getProdutoPadrao() {
        return produtoPadrao;
    }

    public void setProdutoPadrao(ProdutoPadrao produtoPadrao) {
        this.produtoPadrao = produtoPadrao;
    }
    
    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Promocao getPromo() {
        return promo;
    }

    public void setPromo(Promocao promo) {
        this.promo = promo;
    }

    public Cooperador getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Cooperador fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto(String nome, double valor, String detalhes, Tipo tipo, Promocao promo, Cooperador fornecedor, String imagem, int id, int quantidade, ProdutoPadrao produtoPadrao, double total) {
        this.nome = nome;
        this.valor = valor;
        this.detalhes = detalhes;
        this.tipo = tipo;
        this.promo = promo;
        this.fornecedor = fornecedor;
        this.imagem = imagem;
        this.id = id;
        this.quantidade = quantidade;
        this.produtoPadrao = produtoPadrao;
        this.total = total;
    }

    

    

    

    

    public Produto() {
    }
    
    
    


}
