/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Endereco;

/**
 *
 * @author Thiago
 */
public interface IEnderecoDao {
    
     public void cadastrarEndereco(Endereco endereco);
    
    public Endereco consultarEndereco(Endereco endereco);
    
    public Endereco consultarEnderecoPCad(Endereco endereco);
    
    public boolean alterarEndereco(Endereco endereco);
    
    public boolean excluirEndereco(Endereco endereco);
    
}
