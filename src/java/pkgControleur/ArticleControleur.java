package pkgControleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgDbManager.ArticleDB;
import pkgDbManager.CategorieDB;
import pkgEntities.Article;
import pkgEntities.Categorie;
import pkgFormManager.Panier;

/**
 *
 * @author Martin
 */
@WebServlet(urlPatterns = {"/Article"})
public class ArticleControleur extends AbstractControleur{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{        
        ArticleDB articleDB = new ArticleDB(); // Récupération du Manager des articles
        
        session = request.getSession();
        panier = (Panier) session.getAttribute("panier");
        if(panier == null) {
            panier = new Panier();
        }
        
        /*************************************************************************************
        *                               FORMULAIRE
        *************************************************************************************/
        
        if(request.getParameter("action") != null && request.getParameter("article_id") != null){ //On ne fait l'action que SI un formulaire a été soumis et que l'ID existe
                        
            /* Récupération des paramètres pour ajouter un article */
            String action = request.getParameter("action");
            int article_id = Integer.parseInt(request.getParameter("article_id"));

            /* Si un article est à ajouter */
            if(action.equals("Ajouter")) {
                Article article = articleDB.get(article_id);
                panier.addArticle(article);
            }   
        }
        
        /*************************************************************************************
        *                               PANIER             
        /*************************************************************************************/
        
        session.setAttribute("panier",panier);
        
        /*************************************************************************************
        *                                ARTICLE
        *************************************************************************************/
        
        String path = (String) session.getAttribute("article");
        int id = Integer.parseInt(path);
        Article article = articleDB.get(id);
        session.setAttribute("article", article);
        
        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/ArticleControleur.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    
    public void callServlet(HttpServletRequest request, HttpServletResponse response, String servlet) throws ServletException, IOException {
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher(servlet);
        rd.forward(request, response);
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
