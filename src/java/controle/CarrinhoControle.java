/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAOs.ProdutoDao;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CarrinhoControle", urlPatterns = {"/CarrinhoControle"})
public class CarrinhoControle extends HttpServlet {

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

                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                HttpSession session = request.getSession();
                
                ProdutoDao pd = new ProdutoDao();

                switch (flag) {

                    case "ViewCarrinho":
                        
                        String prod = (String) session.getAttribute("carrinho");
                        request.setAttribute("carrinhoview", pd.listaprodutoscarrinho(prod));
                        request.getRequestDispatcher("/jsp/Carrinho.jsp").forward(request, response);

                        break;

                    case "AdicionarProduto":


                        String produtos = (String) session.getAttribute("carrinho");

                        produtos += "," + request.getParameter("id");

                        session.setAttribute("carrinho", produtos);

                        response.sendRedirect("ControleHome?flag=inicio");

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
