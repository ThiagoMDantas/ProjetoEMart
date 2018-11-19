/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.ICartaoDao;
import beans.Cartao;
import java.sql.Connection;
import java.sql.Date;
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
public class CartaoDao implements ICartaoDao{

     
    private static final String INSERT = "INSERT INTO Cartao (numero_cart, portador_cart, cod_cart, validade_cart, cliente_cart) VALUES ( ?, ?, ?, ?, ?);";
    private static final String DELETE = "DELETE FROM Cartao where id_cart=?";
    private static final String BUSCAR = "SELECT * FROM Cartao WHERE cliente_cart=?;";
    private static final String UPDATE = "UPDATE Cartao SET numero_cart=?, portador_cart=?, cod_cart=?, validade_cart=? WHERE cliente_cart=?;";

    private Connection conexao;

    
    @Override
    public void cadastrarCartao(Cartao cartao) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setInt(1, cartao.getNumero());
            pstmt.setString(2, cartao.getPortador());
            pstmt.setInt(3, cartao.getCodigo());
            pstmt.setDate(4, (Date) cartao.getValidade());
            pstmt.setInt(5, cartao.getCliente().getId());
            

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }

    @Override
    public Cartao consultarCartao(Cartao cartao) {

        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setInt(1, cartao.getCliente().getId());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            cartao.setId(rs.getInt("id_cart"));
            cartao.setNumero(rs.getInt("numero_cart"));
            cartao.setPortador(rs.getString("portador_cart"));
            cartao.setCodigo(rs.getInt("cod_cart"));
            cartao.setValidade(rs.getDate("id_cart"));
            return cartao;
            
            
        }catch(Exception ex){
        
            Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);
            
            return cartao;
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        
    
        
        
    }

    @Override
    public boolean alterarCartao(Cartao cartao) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setInt(1, cartao.getNumero());
            pstmt.setString(2, cartao.getPortador());
            pstmt.setInt(3, cartao.getCodigo());
            pstmt.setDate(4, (Date) cartao.getValidade());
            pstmt.setInt(5, cartao.getCliente().getId());
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public boolean excluirCartao(Cartao cartao) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, cartao.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(CartaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
