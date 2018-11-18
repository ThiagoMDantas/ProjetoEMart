/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.ProdutoPadrao;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface IProdutoPadraoDao {
    
    public void cadastrarProdutoPadrao(ProdutoPadrao produtoPadrao);
    
    public ProdutoPadrao consultarProdutoPadrao(ProdutoPadrao produtoPadrao);
    
    public ArrayList<ProdutoPadrao> consultarTodosProdutoPadrao(ProdutoPadrao produtoPadrao);
    
    public  boolean alterarProdutoPadrao(ProdutoPadrao produtoPadrao);
    
    public boolean excluirProdutoPadrao(ProdutoPadrao produtoPadrao);
    
}
