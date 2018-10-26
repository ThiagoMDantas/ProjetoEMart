/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author Thiago
 */
public class Compra {

    private Carrinho carrinho;
    private Cliente cliente;
    private Date dtCompra;
    private Entregador entregador;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public Compra(Carrinho carrinho, Cliente cliente, Date dtCompra, Entregador entregador, int id) {
        this.carrinho = carrinho;
        this.cliente = cliente;
        this.dtCompra = dtCompra;
        this.entregador = entregador;
        this.id = id;
    }

    public Compra() {
    }
    
    

    
}
