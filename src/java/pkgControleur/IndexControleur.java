package pkgControleur;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgDbManager.ArticleDB;
import pkgEntities.Article;
import pkgEntities.Client;
import pkgFormManager.Panier;

public class IndexControleur extends AbstractControleur {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ArticleDB articleDB = new ArticleDB(); // Récupération du Manager des articles
        
        
        /*************************************************************************************
        *                               FORMULAIRE
        *************************************************************************************/
        
        if(request.getParameter("action") != null && request.getParameter("article_id") != null){ //On ne fait l'action que SI un formulaire a été soumis et que l'ID existe
            
            /* Récupération des paramètres pour ajouter un article */
            String action = request.getParameter("action");
            int article_id = Integer.parseInt(request.getParameter("article_id"));

            /* Si un article est à ajouter */
            if(action.equals("Ajouter")) {
                Article article3 = articleDB.get(article_id);
                panier.addArticle(article3);
            }   
        }
        
        /*************************************************************************************
        *                               PANIER             
        /*************************************************************************************/
        
        session = request.getSession();
        panier = (Panier) session.getAttribute("panier");
        if(panier == null) {
            panier = new Panier();
        }
        
        session.setAttribute("panier",panier);
        
        
        /*************************************************************************************
        *                                ARTICLE
        *************************************************************************************/
        
        /* Récupération de la liste d'articles  */
        List<Article> listArticle = articleDB.getAll();
        
        /* Sauvegarde de la listes d'articles dans la session  */
        session.setAttribute("listArticle",listArticle); 
        
        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/IndexControleur.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
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
