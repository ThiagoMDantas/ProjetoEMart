/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IEntregadorDao;
import beans.Endereco;
import beans.Entregador;
import beans.Login;
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
public class EntregadorDao implements IEntregadorDao{

    private static final String INSERT = "INSERT INTO Entregador (nome_ent, telefone_ent, cnpj_cpf_ent, endereço_ent, placa_veiculo_ent, email_ent, login_ent) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "DELETE FROM Entregador where id_ent=?";
    private static final String BUSCAR = "SELECT * FROM Entregador WHERE id_ent=?;";
    private static final String UPDATE = "UPDATE Entregador SET nome_ent=?, telefone_ent=?, cnpj_cpf_ent=?, endereco_ent=?, placa_veiculo_ent=?, email_ent=?, login_ent=? WHERE id_ent=?;";

    private Connection conexao;

    
    @Override
    public void cadastrarEntregador(Entregador entregador) {
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, entregador.getNome());
            pstmt.setInt(2, entregador.getTelefone());
            pstmt.setInt(3, entregador.getCpf());
            pstmt.setInt(4, entregador.getEndereco().getId());
            pstmt.setString(5, entregador.getVeiculo());
            pstmt.setString(6, entregador.getEmail());
            pstmt.setInt(7, entregador.getLogin().getId());
            

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        

    }

    @Override
    public Entregador consultarEntregador(Entregador entregador) {

        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setInt(1, entregador.getId());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();
            
            entregador.setId(rs.getInt("id_ent"));
            entregador.setNome(rs.getString("nome_ent"));
            entregador.setTelefone(rs.getInt("telefone_ent"));
            entregador.setCpf(rs.getInt("cnpj_cpf_ent"));
            
            Endereco end = new Endereco();
            end.setId(rs.getInt("endereco_ent"));
            entregador.setEndereco(end);
            
            entregador.setVeiculo(rs.getString("placa_veiculo_ent"));
            entregador.setEmail(rs.getString("email_ent"));
            
            Login log = new Login();
            log.setId(rs.getInt("login_ent"));
            entregador.setLogin(log);
            
            
            return entregador;
            
            
        }catch(Exception ex){
        
            Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);
            
            return entregador;
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }

    }

    @Override
    public boolean alterarEntregador(Entregador entregador) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, entregador.getNome());
            pstmt.setInt(2, entregador.getTelefone());
            pstmt.setInt(3, entregador.getCpf());
            pstmt.setInt(4, entregador.getEndereco().getId());
            pstmt.setString(5, entregador.getVeiculo());
            pstmt.setString(6, entregador.getEmail());
            pstmt.setInt(7, entregador.getLogin().getId());
            pstmt.setInt(8, entregador.getId());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean excluirEntregador(Entregador entregador) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, entregador.getId());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(EntregadorDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
