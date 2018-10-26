/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Promocao;

/**
 *
 * @author Thiago
 */
public interface IPromocaoDao {
    
    public void cadastrarPromocao(Promocao promocao);
    
    public boolean alterarPromocao(Promocao promocao);
    
    public boolean excluirPromocao(Promocao promocao);
    
    public Promocao consultarPromocao(Promocao promocao);
    
    
}
