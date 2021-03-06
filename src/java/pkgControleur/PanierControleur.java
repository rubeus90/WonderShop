package pkgControleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgDbManager.ArticleDB;
import pkgEntities.Article;
import pkgFormManager.Panier;

public class PanierControleur extends AbstractControleur {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        session = request.getSession();
        panier = (Panier) session.getAttribute("panier");
        if(panier == null) {
            panier = new Panier();
        }
        
        /****************************************************************************/
        
        if(request.getParameter("action") != null && request.getParameter("article_id") != null){ //On ne fait l'action que SI un formulaire a été soumis et que l'ID existe
            
            // Recupère les actions sur le panier
            String action = request.getParameter("action");
            int article_id = Integer.parseInt(request.getParameter("article_id"));

            ArticleDB articleDB = new ArticleDB();
            Article article = articleDB.get(article_id);
            switch (action) {
                case "Ajouter":
                    panier.addArticle(article);
                    break;
                case "Supprimer":
                    panier.removeArticle(article);
                    break;
            }
        }
        
        /****************************************************************************/
        
        session.setAttribute("panier", panier);
        
        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/PanierControleur.jsp").forward(request, response);
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
