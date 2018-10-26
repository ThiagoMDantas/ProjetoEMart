/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Compra;

/**
 *
 * @author Thiago
 */
public interface ICompraDao {
    
     public void calcularTotalCompra(Compra compra);
    
    public Compra consultarCompra(Compra compra);
    
    public Compra listarCompra(Compra compra);
    
    public boolean realizarCompra(Compra compra);
    
}
