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
public class Entregador extends Pessoa{
    
    private String veiculo;

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Entregador(String veiculo, String nome, String dtNascimento, String email, String cpf, String sexo, int telefone, Endereco endereco, Login login, int id) {
        super(nome, dtNascimento, email, cpf, sexo, telefone, endereco, login, id);
        this.veiculo = veiculo;
    }
  
    public Entregador() {
    }
    
    
    
    
    
}
