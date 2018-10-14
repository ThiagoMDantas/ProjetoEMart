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
public class Cliente extends Pessoa{
    
    private Cartao cart;

    public Cartao getCart() {
        return cart;
    }

    public void setCart(Cartao cart) {
        this.cart = cart;
    }
    
    public Cliente(Cartao cart, String nome, Date dtNascimento, String email, String cpf, String sexo, int telefone) {
        super(nome, dtNascimento, email, cpf, sexo, telefone);
        this.cart = cart;
    }

    public Cliente() {
    }
    
    
    
    
    
    
    
}
