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
public class Funcionario extends Pessoa{

    private int numFuncionario;

    public int getnumFuncionario() {
        return numFuncionario;
    }

    public void setnumFuncionario(int numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public Funcionario(int numFuncionario, String nome, Date dtNascimento, String email, String cpf, String sexo, int telefone) {
        super(nome, dtNascimento, email, cpf, sexo, telefone);
        this.numFuncionario = numFuncionario;
    }
    
    
    public Funcionario() {
    }
    
    
    
    
    
}
