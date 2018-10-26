/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Carrinho;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface ICarrinhoDao {
    
    public void adcionarCarrinho(Carrinho carrinho);
    
    public ArrayList<Carrinho> listarCarrinho(Carrinho carrinho);
    
    public boolean alterarCarrinho(Carrinho carrinho);
    
    public boolean limparCarrinho(Carrinho carrinho);
    
}
