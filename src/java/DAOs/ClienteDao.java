/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Interfaces.IClienteDao;
import beans.Cliente;
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
public class ClienteDao implements IClienteDao{

    private static final String INSERT = "INSERT INTO cliente (nome_cli, cpf_cli, sexo_cli, telefone_cli, dt_nasci_cli, email_cli) VALUES ( ?, ?, ?, ?, ?, ?);";
    private static final String DELETE = "DELETE FROM cliente where cpf_cli=?";
    private static final String BUSCAR = "SELECT * FROM cliente WHERE cpf_cli=?;";
    private static final String UPDATE = "UPDATE cliente SET nome_cli=?, cpf_cli=?, sexo_cli=?, telefone_cli=?, dt_nasci_cli=?, email_cli=? WHERE cpf_cli=?;";

    
    private Connection conexao;
    
    @Override
    public void cadatrarCliente(Cliente cliente) {
    
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getSexo());
            pstmt.setInt(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getDtNascimento());
            pstmt.setString(6, cliente.getEmail());
            

            pstmt.execute();


        } catch (Exception ex) {

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    
    
    }

    @Override
    public Cliente consultarCliente(Cliente cliente) {
    
        try{
            
            conexao = ConectaBanco.getConexao();
            
            PreparedStatement pstmt = conexao.prepareCall(BUSCAR);
            
            pstmt.setString(1, cliente.getCpf());
            
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            cliente.setNome(rs.getString("nome_cli"));
            cliente.setCpf(rs.getString("cpf_cli"));
            cliente.setSexo(rs.getString("sexo_cli"));
            cliente.setEmail(rs.getString("email_cli"));
            cliente.setDtNascimento(rs.getString("dt_nasci_cli"));
            cliente.setTelefone(rs.getInt("telefone_cli"));
            
            
            
        }catch(Exception ex){
        
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            
        
        
        }finally{
        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
        return cliente;
    
    }

    @Override
    public boolean alterarCliente(Cliente cliente) {

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getSexo());
            pstmt.setInt(4, cliente.getTelefone());
            pstmt.setString(5, cliente.getDtNascimento());
            pstmt.setString(6, cliente.getEmail());
            pstmt.setString(7, cliente.getCpf());
            
            pstmt.execute();
            return true;

        } catch (Exception ex) {

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public boolean excluirCliente(Cliente cliente) {
        
        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setString(1, cliente.getCpf());

            pstmt.execute();

            return true;

        } catch (Exception ex) {

            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
