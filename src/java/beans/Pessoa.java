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
public class Pessoa {
    
    private String nome;
    private String dtNascimento;
    private String email;
    private int cpf;
    private String sexo;
    private int telefone;
    private Endereco endereco;
    private Login login;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Pessoa(String nome, String dtNascimento, String email, int cpf, String sexo, int telefone, Endereco endereco, Login login, int id) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.id = id;
    }

    public Pessoa() {
    }

    
    
    
    
    
}
