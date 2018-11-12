/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IItemCarrinhoDao;
import beans.Cooperador;
import beans.ItemCarrinho;
import beans.Produto;
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
public class ItemCarrinhoDao implements IItemCarrinhoDao{

    private static final String SELECT_ALL = "SELECT * FROM ItensProd;";
    private static final String INSERT = "INSERT INTO ItensProd (prod_itens, quantidade_itens) VALUES (?, ?);";
    private static final String DELETE = "DELETE FROM ItensProd where id_itens=?";
    private static final String BUSCAR = "SELECT * FROM ItensProd WHERE id_itens=?;";
    private static final String UPDATE = "UPDATE ItensProd SET prod_itens=?, quantidade_itens=? WHERE id_itens=?;";

    
    private Connection conexao;
    
    
    @Override
    public void adcionarItem(ItemCarrinho itemcarrinho) {
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setInt(1, itemcarrinho.getProduto().getId());
            pstmt.setInt(2, itemcarrinho.getQuantidade());
            
            

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        

    }

    @Override
    public void removerItem(ItemCarrinho itemcarrinho) {
         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, itemcarrinho.getId());

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }

    @Override
    public ArrayList<ItemCarrinho> listarItem(ItemCarrinho itemcarrinho) {

        ArrayList<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            //executa
            ResultSet rs = pstmt.executeQuery();
            
            

            while (rs.next()) {
                //a cada loop
                ItemCarrinho item = new ItemCarrinho();
                item.setId(rs.getInt("id_itens"));
                item.setQuantidade(Integer.parseInt(rs.getString("quantidade_itens")));
                
                Produto prod = new Produto();
                prod.setId(rs.getInt("prod_itens"));
                item.setProduto(prod);

                //add na lista
                itens.add(item);
            }
            return itens;

        } catch (Exception ex) {
            
            return itens;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void lterarItem(ItemCarrinho itemcarrinho) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setInt(1, itemcarrinho.getProduto().getId());
            pstmt.setInt(2, itemcarrinho.getQuantidade());
            pstmt.setInt(3, itemcarrinho.getId());
            
            pstmt.execute();
          

        } catch (Exception ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
          

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }
    
}
