/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.ICooperadorDao;
import beans.Cooperador;
import beans.Endereco;
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
 * @author alunocmc
 */
public class CooperadorDao implements ICooperadorDao{
    
    private static final String INSERT = "INSERT INTO fornecedor (nome_for, endereco_for, CNPJ_for, telefone_for, email_for, login_for) VALUES ( ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "DELETE FROM fornecedor where id_for=?";
    private static final String BUSCAR = "SELECT * FROM fornecedor WHERE login_for=?;";
    private static final String UPDATE = "UPDATE fornecedor SET nome_for=?, CNPJ_for=?, telefone_for=?, email_for=? WHERE id_for=?;";

    private Connection conexao;


    @Override
    public void cadastrarCooperador(Cooperador cooperador) {
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, cooperador.getNomeEmpresa());
            pstmt.setInt(2, cooperador.getEnderecoEmpresa().getId());
            pstmt.setInt(3, cooperador.getCnpj());
            pstmt.setInt(4, cooperador.getTelefoneEmpresa());
            pstmt.setString(5, cooperador.getEmailEmpresa());
            pstmt.setInt(6, cooperador.getLogin().getId());
            

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }
    

    @Override
    public Cooperador consultarCooperador(Cooperador cooperador) {

         try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setInt(1, cooperador.getLogin().getId());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            Login login = new Login();
            login.setId(rs.getInt("login_for"));
            
            Endereco end = new Endereco();
            end.setId(rs.getInt("endereco_for"));
            
            
            cooperador.setId(rs.getInt("id_for"));
            cooperador.setNomeEmpresa(rs.getString("nome_for"));
            cooperador.setCnpj(rs.getInt("cnpj_for"));
            cooperador.setTelefoneEmpresa(rs.getInt("telefone_for"));
            cooperador.setEmailEmpresa(rs.getString("email_for"));
            cooperador.setLogin(login);
            cooperador.setEnderecoEmpresa(end);
            
            
            
            return cooperador;
            
        }catch(Exception ex){
        
            Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return cooperador;
        
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    
        
    }

    @Override
    public boolean alterarCooperador(Cooperador cooperador) {
    
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, cooperador.getNomeEmpresa());
            pstmt.setInt(2, cooperador.getCnpj());
            pstmt.setInt(3, cooperador.getTelefoneEmpresa());
            pstmt.setString(4, cooperador.getEmailEmpresa());
            pstmt.setInt(5, cooperador.getId());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean excluirCooperador(Cooperador cooperador) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, cooperador.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CooperadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
    
}
