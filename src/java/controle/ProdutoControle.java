/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAOs.ProdutoDao;
import beans.Cooperador;
import beans.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "ProdutoControle", urlPatterns = {"/ProdutoControle"})
public class ProdutoControle extends HttpServlet {

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
            if (flag == null) {

                request.getRequestDispatcher("/jsp/MinhaConta.jsp").forward(request, response);

            } else {
                
                        Produto prod = new Produto();
                        ProdutoDao pd = new ProdutoDao();
                        
                        Cooperador coop = new Cooperador();

                switch (flag) {
                    case "consultar":
                        //login retorna fornecedor
                        pd.consultarProdutoPorFornecedor(prod);
                        
                        break;
                    case "exluir":
                        prod.setId(Integer.parseInt(request.getParameter("checkId")));
                        pd.excluirProduto(prod);
                        
                        break;
                    case "alterar":
                        prod.setId(Integer.parseInt(request.getParameter("checkId")));
                        request.setAttribute("alterarProduto", pd.consultarProduto(prod));
                        request.getRequestDispatcher("/jsp/AlterarProduto.jsp").forward(request, response);
                        break;
                    case "cadastrar":
                         request.getRequestDispatcher("/jsp/CadastrarProduto.jsp").forward(request, response);
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
