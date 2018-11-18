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
public class ProdutoPadrao {
    private int id;
    private String nomePadrao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePadrao() {
        return nomePadrao;
    }

    public void setNomePadrao(String nomePadrao) {
        this.nomePadrao = nomePadrao;
    }

    
    public ProdutoPadrao() {
    }

    public ProdutoPadrao(int id, String nomePadrao) {
        this.id = id;
        this.nomePadrao = nomePadrao;
    }
    
    
    
    
}
