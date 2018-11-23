/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAOs.CooperadorDao;
import DAOs.EnderecoDao;
import DAOs.LoginDao;
import DAOs.ProdutoDao;
import beans.Cooperador;
import beans.Endereco;
import beans.Login;
import beans.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "CooperadorControle", urlPatterns = {"/CooperadorControle"})
public class CooperadorControle extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag = request.getParameter("flag");
        try (PrintWriter out = response.getWriter()) {
            
           if(flag == null){
               
               request.getRequestDispatcher("index.jsp").forward(request, response);
               
           }else{
               
                HttpSession session = request.getSession();
               
               switch(flag){
               
                   case "cadastroPage":
                       request.getRequestDispatcher("/jsp/CadastrarCooperador.jsp").forward(request, response);
                    break;
                    
                   case "cadastrarCooperador":
                                    
                       Cooperador coop = new Cooperador();
                       coop.setNomeEmpresa(request.getParameter("txtempresa"));
                       coop.setCnpj(Integer.parseInt(request.getParameter("txtcnpj")));
                       coop.setTelefoneEmpresa(Integer.parseInt(request.getParameter("txttelefone")));
                       coop.setEmailEmpresa(request.getParameter("txtemail"));
                       
                       Endereco end = new Endereco();
                       end.setRua(request.getParameter("txtrua"));
                       end.setNumero(Integer.parseInt(request.getParameter("txtnumero")));
                       end.setBairro(request.getParameter("txtbairro"));
                       end.setCep(Integer.parseInt(request.getParameter("txtcep")));
                       end.setComplemento(request.getParameter("txtcomplemento"));
                       end.setCidade(request.getParameter("txtcidade"));
                       end.setEstado(request.getParameter("txtestado"));
                       coop.setEnderecoEmpresa(end);
                       
                       EnderecoDao enddao = new EnderecoDao();
                       enddao.cadastrarEndereco(end);
                       coop.setEnderecoEmpresa(enddao.consultarEnderecoPCad(end));
                       
                       Login log = new Login();
                       log.setUsuario(request.getParameter("txtcadusuario"));
                       log.setSenha(request.getParameter("txtcadsenha"));
                       
                                              
                       LoginDao logdao = new LoginDao();
                       logdao.cadatrarLogin(log);                       
                       coop.setLogin(logdao.consultarLogin(log));
                       
                       CooperadorDao coopdao = new CooperadorDao();
                       coopdao.cadastrarCooperador(coop);
                       
                       request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
                       
                       break;
                       
                   case "MinhaConta":
                       
                       Produto produto = new Produto();
                       produto.setFornecedor((Cooperador) session.getAttribute("dados"));
                       ProdutoDao prod = new ProdutoDao();
                       request.setAttribute("ProdutosCooperador", prod.consultarProdutoPorFornecedor(produto));
                       
                       request.getRequestDispatcher("/jsp/MinhaConta.jsp").forward(request, response);
                      
                       break;
               
               }
               
               
           
           }
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
