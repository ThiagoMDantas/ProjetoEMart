/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Produto;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface IProdutoDao {
    
    public void cadastarProduto(Produto produto);
    
    public Produto consultarProduto(Produto produto);
    
    public ArrayList consultarTodosProduto(Produto produto);
    
    public ArrayList consultarProdutoPorFornecedor(Produto produto);
    
    public ArrayList buscarPeloNome(Produto produto);
    
    public ArrayList buscarPeloTipo(Produto produto);
    
    public boolean alterarProduto(Produto produto);
    
    public boolean excluirProduto(Produto produto);
    
    
    
}
