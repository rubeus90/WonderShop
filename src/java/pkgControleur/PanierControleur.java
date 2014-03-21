package pkgControleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        session = request.getSession();
        panier = (Panier) session.getAttribute("panier");
        if(panier == null) {
            session.setAttribute("panier", new Panier());
        }
        
        /*
        // Recupère les actions sur le panier
        String action = (String) session.getAttribute("action");
        String article_nom = (String) session.getAttribute("article");
        
        Article article;
        if(action!=null && article_nom!=null) {
            switch (action) {
                case "Ajouter":
                    article = panier.getArticle(article_nom);
                    panier.addArticle(article);
                    break;
                case "Supprimer":
                    article = panier.getArticle(article_nom);
                    panier.removeArticle(article);
                    break;
            }
        }
        */
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
