/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAOs.ClienteDao;
import DAOs.CooperadorDao;
import DAOs.LoginDao;
import DAOs.ProdutoDao;
import beans.Cliente;
import beans.Cooperador;
import beans.Login;
import beans.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thiago
 */
public class LoginControle extends HttpServlet {

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
                Login login = new Login();
                LoginDao logindao = new LoginDao();
                
                Cooperador coop = new Cooperador();
                CooperadorDao coopd = new CooperadorDao();
                
                Cliente cli = new Cliente();
                ClienteDao cd = new ClienteDao();
                
                
                Produto prod = new Produto();
                ProdutoDao pd = new ProdutoDao();
                
                HttpSession session = request.getSession();
           
               switch(flag){
               
                   case "Formlogin":
                       request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
                    break;
                    
                    case "FormloginCoop":
                       request.getRequestDispatcher("/jsp/LoginCooperador.jsp").forward(request, response);
                    break;
                    
                    case "realizarLogin":
                        
                       
                            //nome dos campos da jsp
                            login.setUsuario(request.getParameter("txtusuario"));
                            login.setSenha(request.getParameter("txtsenha"));
                       
                            cli.setLogin(logindao.realizarLogin(login));
                            session.setAttribute("dados", cd.consultarCliente(cli));
                            
                            request.getRequestDispatcher("ControleHome?flag=inicio").forward(request, response);
                        
                    break;
                    
                    case "realizarLoginCoop":
                        
                        //nome dos campos da jsp
                        login.setUsuario(request.getParameter("txtusuario"));
                        login.setSenha(request.getParameter("txtsenha"));
                        
                        coop.setLogin(logindao.consultarLogin(login));
                        session.setAttribute("dados",coopd.consultarCooperador(coop));
                        
                        
                        prod.setFornecedor(coopd.consultarCooperador(coop));
                        
                        request.setAttribute("produtosFornecedor", pd.consultarProdutoPorFornecedor(prod));
                        
                        request.getRequestDispatcher("CooperadorControle?flag=MinhaConta").forward(request, response);
                        
                    break;
                       
                   case "Formcadastrar":
                       request.getRequestDispatcher("/jsp/Cadastrar.jsp").forward(request, response);
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
