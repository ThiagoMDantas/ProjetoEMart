/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Entregador;

/**
 *
 * @author Thiago
 */
public interface IEntregadorDao {
    
    
    public void cadastrarFEntregador(Entregador entregador);
    
    public Entregador consultarEntregador(Entregador entregador);
    
    public boolean alterarEntregador(Entregador entregador);
    
    public boolean excluirEntregador(Entregador entregador);
    
}
