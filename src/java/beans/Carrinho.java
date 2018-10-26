/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;


/**
 *
 * @author Thiago
 */
public class Carrinho {

    private ArrayList<ItemCarrinho> itens;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public Carrinho() {
    }

    public Carrinho(ArrayList<ItemCarrinho> itens, int id) {
        this.itens = itens;
        this.id = id;
    }

    
    
    

    
}
