/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IProdutoPadraoDao;
import beans.ProdutoPadrao;
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
public class ProdutoPadraoDao implements IProdutoPadraoDao{

    private static final String SELECT_ALL = "SELECT * FROM produtopadrao;";
    private static final String INSERT = "INSERT INTO produtopadrao (id_padr, nome_padr) VALUES ( ?, ?);";
    private static final String DELETE = "DELETE FROM produtopadrao where id_padr=?";
    private static final String BUSCAR = "SELECT * FROM produtopadrao WHERE id_padr=?;";
    private static final String UPDATE = "UPDATE produtopadrao SET nome_padr=? WHERE id_padr=?;";

    
    private Connection conexao;
    
    
    
    @Override
    public void cadastrarProdutoPadrao(ProdutoPadrao produtoPadrao) {

         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setInt(1, produtoPadrao.getId());
            pstmt.setString(2, produtoPadrao.getNomePadrao());

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(ProdutoPadraoDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoPadraoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public ProdutoPadrao consultarProdutoPadrao(ProdutoPadrao produtoPadrao) {
        
        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);
            
            pstmt.setInt(1, produtoPadrao.getId());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            produtoPadrao.setId(rs.getInt("id_padr"));
            produtoPadrao.setNomePadrao(rs.getString("nome_padr"));
            
            
            
            
        }catch(Exception ex){
        
            Logger.getLogger(ProdutoPadraoDao.class.getName()).log(Level.SEVERE, null, ex);
            
        
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoPadraoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        return produtoPadrao;
    
        
    }

    @Override
    public ArrayList<ProdutoPadrao> consultarTodosProdutoPadrao(ProdutoPadrao produtoPadrao) {

         //cria uma array de obJ Situacao
        ArrayList<ProdutoPadrao> listpadrao = new ArrayList<ProdutoPadrao>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            //executa
            ResultSet rs = pstmt.executeQuery();
            
            

            while (rs.next()) {
                //a cada loop
                ProdutoPadrao tp = new ProdutoPadrao();
                tp.setId(rs.getInt("id_padr"));
                tp.setNomePadrao(rs.getString("nome_padr"));

                //add na lista
                listpadrao.add(tp);
            }
            return listpadrao;

        } catch (Exception ex) {
            
            return listpadrao;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoPadrao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean alterarProdutoPadrao(ProdutoPadrao produtoPadrao) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, produtoPadrao.getNomePadrao());
            pstmt.setInt(2, produtoPadrao.getId());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(ProdutoPadrao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoPadrao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean excluirProdutoPadrao(ProdutoPadrao produtoPadrao) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, produtoPadrao.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(ProdutoPadrao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoPadrao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}
