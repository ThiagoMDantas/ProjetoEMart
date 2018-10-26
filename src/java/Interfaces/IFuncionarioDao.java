/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Funcionario;

/**
 *
 * @author Thiago
 */
public interface IFuncionarioDao {
    
    public void cadastrarFuncionario(Funcionario funcionario);
    
    public Funcionario consultarFuncionario(Funcionario funcionario);
    
    public boolean alterarFuncionario(Funcionario funcionario);
    
    public boolean excluirFuncionario(Funcionario funcionario);
}
