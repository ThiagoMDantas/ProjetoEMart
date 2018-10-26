/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.ItemCarrinho;

/**
 *
 * @author Thiago
 */
public interface IItemCarrinhoDao {

    public void adcionarItem(ItemCarrinho itemcarrinho);
    
    public void removerItem(ItemCarrinho itemcarrinho);
    
    
    
}
