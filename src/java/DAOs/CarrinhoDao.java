/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.ICarrinhoDao;
import beans.Carrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConectaBanco;

/**
 *
 * @author Thiago
 */
public class CarrinhoDao implements ICarrinhoDao{
    
    private static final String SELECT_ALL = "SELECT * FROM carrinho;";
    private static final String INSERT = "INSERT INTO carrinho (id_itens_car) VALUES (?);";
    private static final String DELETE = "DELETE FROM carrinho where id_car=?";
    private static final String BUSCAR = "SELECT * FROM carrinho WHERE id_car=?;";
    private static final String UPDATE = "UPDATE carrinho SET id_itens_car=? WHERE id_car=?;";

    
    private Connection conexao;

    @Override
    public void adcionarCarrinho(Carrinho carrinho) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setInt(1, carrinho.getItens().get(0).getId());
            

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
    public ArrayList<Carrinho> listarCarrinho(Carrinho carrinho) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarCarrinho(Carrinho carrinho) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean limparCarrinho(Carrinho carrinho) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
