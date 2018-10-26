/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Produto;

/**
 *
 * @author Thiago
 */
public interface IProdutoDao {
    
    public void cadastarProduto(Produto produto);
    
    public Produto consultarProduto(Produto produto);
    
    public boolean alterarProaduto(Produto produto);
    
    public boolean excluirProaduto(Produto produto);
    
    
    
}
