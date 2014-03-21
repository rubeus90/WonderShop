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
import pkgDbManager.CommandeDB;
import pkgEntities.Client;
import pkgEntities.Commande;
import pkgFormManager.Panier;

/**
 *
 * @author rubeus
 */
public class AchatControleur extends AbstractControleur {

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
        
        // Récuperation des attributs de la session
        session = request.getSession();
        panier = (Panier) session.getAttribute("panier");
        if(panier == null) {
            session.setAttribute("panier", new Panier());
        }
        client = (Client) session.getAttribute("client");
        
        // Si un client est identifie
        if(client!=null) {
            // Sauvegarde du panier dans la BDD grâce à CommandeDB
            CommandeDB commandeDB = new CommandeDB();
            List<Commande> listCommande = panier.getCommande(client, commandeDB.getLastId());
            // Attention : une commade par article
            for(Commande commande:listCommande) {
                CommandeDB db = new CommandeDB();
                db.add(commande);
            }
        }
        
        try {
            this.getServletContext().getRequestDispatcher("/WEB-INF/AchatControleur.jsp").forward(request, response);
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
