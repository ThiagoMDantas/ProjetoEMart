/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.ITipoDao;
import beans.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConectaBanco;

/**
 *
 * @author Thiago
 */
public class TipoDao implements ITipoDao{

    private static final String SELECT_ALL = "SELECT * FROM tipo;";
    private static final String INSERT = "INSERT INTO tipo (id_tp, setor_tp) VALUES ( ?, ?);";
    private static final String DELETE = "DELETE FROM tipo where id_tp=?";
    private static final String BUSCAR = "SELECT * FROM tipo WHERE setor_tp=?;";
    private static final String UPDATE = "UPDATE tipo SET setor_tp=? WHERE id_tp=?;";

    
    private Connection conexao;
    
    
    @Override
    public void cadastrarTipo(Tipo tipo) {
    
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setInt(1, tipo.getId());
            pstmt.setString(2, tipo.getTipo());

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
    }

    @Override
    public Tipo consultarTipo(Tipo tipo) {

        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setString(1, tipo.getTipo());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            tipo.setId(rs.getInt("id_tp"));
            tipo.setTipo(rs.getString("setor_tp"));
            
            
            
            
        }catch(Exception ex){
        
            Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            
        
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        return tipo;
    

    }

    @Override
    public boolean alterarTipo(Tipo tipo) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, tipo.getTipo());
            pstmt.setInt(2, tipo.getId());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean excluirTipo(Tipo tipo) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, tipo.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public ArrayList<Tipo> consultarTodosTipo(Tipo tipo) {

         //cria uma array de obJ Situacao
        ArrayList<Tipo> listatipo = new ArrayList<Tipo>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            //executa
            ResultSet rs = pstmt.executeQuery();
            
            

            while (rs.next()) {
                //a cada loop
                Tipo tp = new Tipo();
                tp.setId(rs.getInt("id_tp"));
                tp.setTipo(rs.getString("setor_tp"));

                //add na lista
                listatipo.add(tp);
            }
            return listatipo;

        } catch (Exception ex) {
            
            return listatipo;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
