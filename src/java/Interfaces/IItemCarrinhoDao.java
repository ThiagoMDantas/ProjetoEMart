/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.ItemCarrinho;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface IItemCarrinhoDao {

    public void adcionarItem(ItemCarrinho itemcarrinho);
    
    public void removerItem(ItemCarrinho itemcarrinho);
    
    public ArrayList<ItemCarrinho> listarItem(ItemCarrinho itemcarrinho);
    
    public void lterarItem(ItemCarrinho itemcarrinho);
    
}
