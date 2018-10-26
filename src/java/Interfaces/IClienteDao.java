/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Cliente;

/**
 *
 * @author Thiago
 */
public interface IClienteDao {
    
    public void cadatrarCliente(Cliente cliente);
    
    public Cliente consultarCliente(Cliente cliente);
    
    public boolean alterarCliente(Cliente cliente);
    
    public boolean excluirCliente(Cliente cliente);
    
}
