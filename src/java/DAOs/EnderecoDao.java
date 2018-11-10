/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IEnderecoDao;
import beans.Endereco;
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
public class EnderecoDao implements IEnderecoDao {

    private static final String INSERT = "INSERT INTO endereco (rua_end, numero_end, bairro_end, complemento_end, cidade_end, estado_end, cep_end) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "DELETE FROM endereco where id_end=?";
    private static final String BUSCAR = "SELECT * FROM endereco WHERE id_end=?;";
    private static final String BUSCARPCAD = "SELECT * FROM endereco WHERE rua_end=? and numero_end=?;";
    private static final String UPDATE = "UPDATE endereco SET rua_end=?, numero_end=?, bairro_end=?, complemento_end=?, cidade_end=?, estado_end=?, cep_end=? WHERE id_end=?;";

    private Connection conexao;
 
    @Override
    public void cadastrarEndereco(Endereco endereco) {

        try {
            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, endereco.getRua());
            pstmt.setInt(2, endereco.getNumero());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setString(4, endereco.getComplemento());
            pstmt.setString(5, endereco.getCidade());
            pstmt.setString(6, endereco.getEstado());
            pstmt.setInt(7, endereco.getCep());

            pstmt.execute();

        } catch (SQLException | ClassNotFoundException e) {

            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Endereco consultarEndereco(Endereco endereco) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, endereco.getId());

            ResultSet rs = pstmt.executeQuery();

            rs.next();

            endereco.setId(Integer.parseInt(rs.getString("id_end")));
            endereco.setRua(rs.getString("rua_end"));
            endereco.setNumero(Integer.parseInt(rs.getString("numero_end")));
            endereco.setBairro(rs.getString("bairro_end"));
            endereco.setComplemento(rs.getString("complemento_end"));
            endereco.setCidade(rs.getString("cidade_end"));
            endereco.setEstado(rs.getString("estado_end"));

        } catch (ClassNotFoundException | SQLException e) {

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return endereco;
    }

    @Override
    public boolean alterarEndereco(Endereco endereco) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, endereco.getRua());
            pstmt.setInt(2, endereco.getNumero());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setString(4, endereco.getComplemento());
            pstmt.setString(5, endereco.getCidade());
            pstmt.setString(6, endereco.getEstado());
            pstmt.setInt(7, endereco.getId());

            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean excluirEndereco(Endereco endereco) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, endereco.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public Endereco consultarEnderecoPCad(Endereco endereco) {
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(BUSCARPCAD);

            pstmt.setString(1, endereco.getRua());
            pstmt.setInt(2, endereco.getNumero());
   
            ResultSet rs = pstmt.executeQuery();

            rs.next();

            endereco.setId(rs.getInt("id_end"));
            endereco.setRua(rs.getString("rua_end"));
            endereco.setNumero(rs.getInt("numero_end"));
            endereco.setBairro(rs.getString("bairro_end"));
            endereco.setComplemento(rs.getString("complemento_end"));
            endereco.setCidade(rs.getString("cidade_end"));
            endereco.setEstado(rs.getString("estado_end"));
            
            return endereco;

        } catch (Exception ex) {  
            
          Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
          return endereco;
      } finally{
      
          try{
              conexao.close();
          } catch (SQLException ex) {
              Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 

}
}
