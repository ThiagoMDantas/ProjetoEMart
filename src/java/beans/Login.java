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
public class Login {
    
    private String usuario;
    private String senha;
    private String lugar;
    private int id;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Login(String usuario, String senha, String lugar, int id) {
        this.usuario = usuario;
        this.senha = senha;
        this.lugar = lugar;
        this.id = id;
    }

    

    public Login() {
    }
    
    
    
    
    
}
