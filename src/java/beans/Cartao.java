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
public class Cartao {
    
    private int numero;
    private String portador;
    private Date validade;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPortador() {
        return portador;
    }

    public void setPortador(String portador) {
        this.portador = portador;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    
    
    public Cartao() {
    }

    public Cartao(int numero, String portador, Date validade) {
        this.numero = numero;
        this.portador = portador;
        this.validade = validade;
    }
    
    
    
}
