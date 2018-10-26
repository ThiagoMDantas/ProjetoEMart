/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Cooperador;

/**
 *
 * @author Thiago
 */
public interface ICooperadorDao {

    public void cadastrarCooperador(Cooperador cooperador);
    
    public Cooperador consultarCooperador(Cooperador cooperador);
    
    public boolean alterarCooperador(Cooperador cooperador);
    
    public boolean excluirCooperador(Cooperador cooperador);
    
}
