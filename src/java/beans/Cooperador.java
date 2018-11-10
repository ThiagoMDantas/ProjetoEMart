/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Thiago
 */
public class Cooperador {
    
    private String nomeEmpresa;
    private int cnpj;
    private String emailEmpresa;
    private int telefoneEmpresa;
    private Endereco enderecoEmpresa;
    private Login login;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public int getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(int telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    public Endereco getEnderecoEmpresa() {
        return enderecoEmpresa;
    }

    public void setEnderecoEmpresa(Endereco enderecoEmpresa) {
        this.enderecoEmpresa = enderecoEmpresa;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Cooperador(String nomeEmpresa, int cnpj, String emailEmpresa, int telefoneEmpresa, Endereco enderecoEmpresa, Login login, int id) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.emailEmpresa = emailEmpresa;
        this.telefoneEmpresa = telefoneEmpresa;
        this.enderecoEmpresa = enderecoEmpresa;
        this.login = login;
        this.id = id;
    }
    
    public Cooperador() {
    }
    
    
    
    
}
