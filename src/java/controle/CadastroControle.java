/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAOs.ClienteDao;
import DAOs.EnderecoDao;
import DAOs.LoginDao;
import beans.Cartao;
import beans.Cliente;
import beans.Endereco;
import beans.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago
 */
public class CadastroControle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String flag = request.getParameter("flag");

        try (PrintWriter out = response.getWriter()) {
            if (flag == null) {

                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {

                switch (flag) {
                    case "realizarCadastro":
                        
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        
                        Cliente cli = new Cliente();
                        cli.setNome(request.getParameter("txtnome"));
                        cli.setSexo(request.getParameter("txtsexo"));
                        cli.setCpf(request.getParameter("txtcpf"));
                        cli.setDtNascimento(request.getParameter("txtdatanasc"));
                        cli.setTelefone(Integer.parseInt(request.getParameter("txttelefone")));
                        cli.setEmail(request.getParameter("txtemail"));
                        
                        
                        
                        Endereco end = new Endereco();
                        end.setRua(request.getParameter("txtrua"));
                        end.setNumero(Integer.parseInt(request.getParameter("txtnumero")));
                        end.setComplemento(request.getParameter("txtcomplemento"));
                        end.setBairro(request.getParameter("txtbairro"));
                        end.setCidade(request.getParameter("txtcidade"));
                        end.setEstado(request.getParameter("txtestado"));
                        end.setCep(Integer.parseInt(request.getParameter("txtcep")));
                        cli.setEndereco(end);
                        
                        
                        Login log = new Login();
                        log.setUsuario(request.getParameter("txtcadusuario"));
                        log.setSenha(request.getParameter("txtcadsenha"));
                        cli.setLogin(log);
                        
                        ClienteDao clidao= new ClienteDao();
                        clidao.cadatrarCliente(cli);
                        
                        LoginDao logdao = new LoginDao();
                        logdao.cadatrarLogin(log);
                        
                        EnderecoDao enddao = new EnderecoDao();
                        enddao.cadastrarEndereco(end);
                        
                        request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
                        
                        break;
                        

                }
            }

        }catch(Error e){
        
            Logger.getLogger(CadastroControle.class.getName()).log(Level.SEVERE, null,e);
            
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
