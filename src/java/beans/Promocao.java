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
public class Promocao {
    
    
    private String nomePromo;
    private int percentPromo;
    private int id;
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomePromo() {
        return nomePromo;
    }

    public void setNomePromo(String nomePromo) {
        this.nomePromo = nomePromo;
    }

    public int getPercentPromo() {
        return percentPromo;
    }

    public void setPercentPromo(int percentPromo) {
        this.percentPromo = percentPromo;
    }

    

    public Promocao(String nomePromo, int percentPromo, int id, Produto produto) {
        this.nomePromo = nomePromo;
        this.percentPromo = percentPromo;
        this.id = id;
        this.produto = produto;
    }

    
    
    public Promocao() {
    }
    
    
    
}
