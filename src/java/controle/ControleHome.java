/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAOs.ProdutoDao;
import DAOs.TipoDao;
import beans.Produto;
import beans.Tipo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "ControleHome", urlPatterns = {"/ControleHome"})
public class ControleHome extends HttpServlet {

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

                switch (flag) {

                    case "inicio":

                        try {
                            Tipo tipo = new Tipo();
                            TipoDao tp = new TipoDao();

                            Produto produto = new Produto();
                            ProdutoDao pd = new ProdutoDao();

                            request.setAttribute("tipos", tp.consultarTodosTipo(tipo));
                            request.setAttribute("produtos", pd.consultarTodosProduto(produto));

                            RequestDispatcher rd = request.getRequestDispatcher("/jsp/Home.jsp");
                            rd.forward(request, response);

                        } catch (Exception ex) {

                            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                            rd.forward(request, response);

                        }

                        break;

                    case "pesquisa":

                        try {
                            Tipo tipo = new Tipo();
                            TipoDao tp = new TipoDao();

                            Produto produto = new Produto();
                            ProdutoDao pd = new ProdutoDao();
                            produto.setNome(request.getParameter("txtpesquisa"));
                            request.setAttribute("tipos", tp.consultarTodosTipo(tipo));
                            request.setAttribute("produtos", pd.buscarPeloNome(produto));

                            RequestDispatcher rd = request.getRequestDispatcher("/jsp/Home.jsp");
                            rd.forward(request, response);
                        } catch (Exception ex) {

                            RequestDispatcher rd = request.getRequestDispatcher("ControleHome?flag=inicio");
                            rd.forward(request, response);
                        }
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
