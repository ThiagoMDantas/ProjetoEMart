/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IProdutoDao;
import beans.Cooperador;
import beans.Produto;
import beans.Tipo;
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
public class ProdutoDao implements IProdutoDao{

    private static final String INSERT = "INSERT INTO produto (nome_prod, tipo_prod, vl_uni_prod, detalhes_prod, fornecedor_ prod) VALUES ( ?, ?, ?, ?, ?);";
    private static final String DELETE = "DELETE FROM produto where id_prod=?";
    private static final String BUSCAR = "SELECT * FROM produto WHERE id_prod=?;";
    private static final String UPDATE = "UPDATE produto SET nome_prod=?, vl_uni_prod=?, detalhes_prod=? WHERE id_prod=?;";

    
    private Connection conexao;
    
    
    @Override
    public void cadastarProduto(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getTipo().getId());
            pstmt.setDouble(3, produto.getValor());
            pstmt.setString(4, produto.getDetalhes());
            pstmt.setInt(5, produto.getFornecedor().getId());
            

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
    public Produto consultarProduto(Produto produto) {

        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setInt(1, produto.getId());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            produto.setId(rs.getInt("id_prod"));
            produto.setNome(rs.getString("nome_prod"));
            produto.setValor(rs.getDouble("vl_uni_prod"));
            produto.setDetalhes(rs.getString("detalhes_prod"));
            
            Cooperador fornecedor = new Cooperador();
            fornecedor.setId(rs.getInt("fornecedor_prod"));
            produto.setFornecedor(fornecedor);
            
            Tipo tipo = new Tipo();
            tipo.setId(rs.getInt("tipo_prod"));
            produto.setTipo(tipo);
            
            
            
        }catch(Exception ex){
        
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            
        
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        return produto;
    
    }

    @Override
    public boolean alterarProaduto(Produto produto) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getValor());
            pstmt.setString(3, produto.getDetalhes());
            pstmt.setInt(4, produto.getId());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }

    @Override
    public boolean excluirProaduto(Produto produto) {

         try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, produto.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
}