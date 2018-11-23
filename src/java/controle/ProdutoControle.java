/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAOs.CooperadorDao;
import DAOs.ProdutoDao;
import DAOs.ProdutoPadraoDao;
import DAOs.TipoDao;
import beans.Cooperador;
import beans.Produto;
import beans.ProdutoPadrao;
import beans.Tipo;
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

                ProdutoPadrao prodpadr = new ProdutoPadrao();
                ProdutoPadraoDao pdpadr = new ProdutoPadraoDao();

                
                Cooperador coop = new Cooperador();
                CooperadorDao coopd = new CooperadorDao();

                Tipo tipo = new Tipo();
                TipoDao tp = new TipoDao();
                
                HttpSession session = request.getSession();

                switch (flag) {
                    
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
                        

                        request.setAttribute("tipos", tp.consultarTodosTipo(tipo));
                        request.setAttribute("Produtospadr", pdpadr.consultarTodosProdutoPadrao(prodpadr));

                        request.getRequestDispatcher("/jsp/CadastrarProduto.jsp").forward(request, response);
                        break;
                        
                        case "CadastrarProduto":
                            
                            prod.setNome(request.getParameter("txtnome"));
                            tipo.setId(Integer.parseInt(request.getParameter("opSetor")));
                            prod.setTipo(tipo);
                            prod.setValor(Double.parseDouble(request.getParameter("txtvalor")));
                            prod.setDetalhes(request.getParameter("txtdetalhes"));
                            prod.setFornecedor((Cooperador) session.getAttribute("dados"));
                            prod.setImagem(request.getParameter("txtimagem"));
                            prod.setQuantidade(Integer.parseInt(request.getParameter("txtquantidade")));
                            prodpadr.setId(Integer.parseInt(request.getParameter("opPadrao")));
                            prod.setProdutoPadrao(prodpadr);
                            
                            pd.cadastarProduto(prod);
                            
                            request.getRequestDispatcher("CooperadorControle?flag=MinhaConta").forward(request, response);
                            
                            
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
