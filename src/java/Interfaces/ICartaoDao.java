/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Cartao;

/**
 *
 * @author Thiago
 */
public interface ICartaoDao {
    
    public void cadastrarCartao(Cartao cartao);
    
    public Cartao consultarCartao(Cartao cartao);
    
    public boolean alterarCartao(Cartao cartao);
    
    public boolean excluirCartao(Cartao cartao);
    
    
}
