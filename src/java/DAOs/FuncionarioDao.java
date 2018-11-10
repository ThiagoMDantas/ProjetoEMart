/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IFuncionarioDao;
import beans.Funcionario;
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
public class FuncionarioDao implements IFuncionarioDao{

    private static final String INSERT = "INSERT INTO Funcionario (nome_fun, cpf_fun, email_fun, login_fun) VALUES ( ?, ?, ?, ?);";
    private static final String DELETE = "DELETE FROM Funcionario where id_fun=?";
    private static final String BUSCAR = "SELECT * FROM Funcionario WHERE id_fun=?;";
    private static final String UPDATE = "UPDATE Funcionario SET nome_fun=?, cpf_fun=?, email_fun=? WHERE id_fun=?;";

    
    private Connection conexao;
    
    
    
    @Override
    public void cadastrarFuncionario(Funcionario funcionario) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, funcionario.getNome());
            pstmt.setInt(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getEmail());
            pstmt.setInt(4, funcionario.getLogin().getId());
            

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public Funcionario consultarFuncionario(Funcionario funcionario) {

        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setInt(1, funcionario.getId());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            funcionario.setId(rs.getInt("id_fun"));
            funcionario.setNome(rs.getString("nome_fun"));
            funcionario.setCpf(rs.getInt("cpf_fun"));
            funcionario.setEmail(rs.getString("email_fun"));
            
            
            Login log = new Login();
            log.setId(rs.getInt("login_fun"));
            funcionario.setLogin(log);
            
            
            
        return funcionario;
            
            
        }catch(Exception ex){
        
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            
        return funcionario;
        
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    
        
    }

    @Override
    public boolean alterarFuncionario(Funcionario funcionario) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, funcionario.getNome());
            pstmt.setInt(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getEmail());
            pstmt.setInt(4, funcionario.getId());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean excluirFuncionario(Funcionario funcionario) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, funcionario.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
