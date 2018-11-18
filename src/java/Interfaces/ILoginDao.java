/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import beans.Login;

/**
 *
 * @author Thiago
 */
public interface ILoginDao {
    
    public void cadatrarLogin(Login login);
    
    public Login realizarLogin(Login login);
    
    public Login consultarLogin(Login login);
    
    public boolean alterarSenha(Login login);
    
    public boolean excluirLogin(Login login);
    
}
