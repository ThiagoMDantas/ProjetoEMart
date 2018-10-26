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
public class ItemCarrinho {
    
    private Produto produto;
    private int quantidade;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ItemCarrinho(Produto produto, int quantidade, int id) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.id = id;
    }

    public ItemCarrinho() {
    }
    
    
    
}
