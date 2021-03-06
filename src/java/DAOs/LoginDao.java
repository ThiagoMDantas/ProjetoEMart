/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.ILoginDao;
import beans.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConectaBanco;

/**
 *
 * @author Thiago
 */
public class LoginDao implements ILoginDao {

    private static final String INSERT = "INSERT INTO login (usuario_log, senha_log) VALUES ( ?, ?);";
    private static final String DELETE = "DELETE FROM login WHERE usuario_log=? and senha_log=?;";
    private static final String BUSCAR = "SELECT * FROM login WHERE usuario_log=? and senha_log=?;";
    private static final String UPDATE = "UPDATE login SET senha_log=? WHERE usuario=? and id_log=?;";

    private Connection conexao;

    @Override
    public void cadatrarLogin(Login login) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, login.getUsuario());
            pstmt.setString(2, login.getSenha());

            pstmt.execute();

        } catch (ClassNotFoundException | SQLException ex) {

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public Login realizarLogin(Login login) {
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setString(1, login.getUsuario());
            pstmt.setString(2, login.getSenha());

            ResultSet rs = pstmt.executeQuery();

            rs.next();

            login.setId(rs.getInt("id_log"));
            login.setUsuario(rs.getString("usuario_log"));
            login.setSenha(rs.getString("senha_log"));


        } catch (Exception ex) {

            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return login;
    }

    @Override
    public boolean alterarSenha(Login login) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareCall(UPDATE);

            pstmt.setString(1, login.getSenha());
            pstmt.setString(2, login.getUsuario());
            pstmt.setInt(3, login.getId());

            pstmt.executeQuery();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean excluirLogin(Login login) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setString(1, login.getUsuario());
            pstmt.setString(2, login.getSenha());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public Login consultarLogin(Login login) {
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setString(1, login.getUsuario());
            pstmt.setString(2, login.getSenha());

            ResultSet rs = pstmt.executeQuery();

            rs.next();

            login.setId(rs.getInt("id_log"));
            login.setUsuario(rs.getString("usuario_log"));
            login.setSenha(rs.getString("senha_log"));

            return login;

        } catch (Exception ex) {

            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            return login;
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
