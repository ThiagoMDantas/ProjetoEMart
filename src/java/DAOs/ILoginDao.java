/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import beans.Login;

/**
 *
 * @author Thiago
 */
public interface ILoginDao {
    
    public boolean cadatrarLogin(Login login);
    
    public boolean realizarLogin(Login login);
    
    public boolean alterarSenha(Login login);
    
    public boolean excluirLogin(Login login);
    
}
