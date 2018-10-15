/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thiago
 */
public class ConectaBanco {
    
    public static Connection getConexao() throws ClassNotFoundException  {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EMart", "postgres", "postgres");
        
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        }
        return conexao;
    }
    
}
