package pkgControleur;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgDbManager.CategorieDB;
import pkgEntities.Article;
import pkgEntities.Categorie;
import pkgFormManager.Panier;

public class CategorieControleur extends AbstractControleur {

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
        
        String path = (String) session.getAttribute("categorie");
        
        CategorieDB categorieDB = new CategorieDB();
        Categorie categorie = categorieDB.get(path);
        List<Article> list = categorieDB.getListArticle(categorie);
        session.setAttribute("listArticle", list);
        
        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/CategorieControleur.jsp").forward(request, response);
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
