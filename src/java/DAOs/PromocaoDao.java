/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IPromocaoDao;
import beans.Produto;
import beans.Promocao;
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
public class PromocaoDao implements IPromocaoDao{
    private static final String SELECT_ALL = "SELECT * FROM promo;";
    private static final String INSERT = "INSERT INTO promocao (nome_promo, pecentual_desc_promo, produto_promo) VALUES (?, ?, ?);";
    private static final String DELETE = "DELETE FROM tipo where id_promo=?";
    private static final String BUSCAR = "SELECT * FROM tipo WHERE nome_promo=?;";
    private static final String UPDATE = "UPDATE tipo SET nome_promo=?, pecentual_desc_promo=? WHERE id_promo=?;";

    
    private Connection conexao;

    @Override
    public void cadastrarPromocao(Promocao promocao) {
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, promocao.getNomePromo());
            pstmt.setInt(2, promocao.getPercentPromo());
            pstmt.setInt(3, promocao.getProduto().getId());
            

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        
        
    }

    @Override
    public boolean alterarPromocao(Promocao promocao) {
        
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, promocao.getNomePromo());
            pstmt.setInt(2, promocao.getPercentPromo());
            pstmt.setInt(3, promocao.getId());
            
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean excluirPromocao(Promocao promocao) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, promocao.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Promocao consultarPromocao(Promocao promocao) {
        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setString(1, promocao.getNomePromo());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            promocao.setId(rs.getInt("id_promo"));
            promocao.setNomePromo(rs.getString("nome_promo"));
            promocao.setPercentPromo(rs.getInt("pecentual_desc_promo"));
            
            Produto prod = new Produto();
            prod.setId(rs.getInt("produto_promo"));
            promocao.setProduto(prod);
            
            
        }catch(Exception ex){
        
            Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);
            
        
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(PromocaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        return promocao;
    }
}
