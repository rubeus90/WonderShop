package pkgControleur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgDbManager.ClientDB;
import pkgEntities.Client;

/**
 *
 * @author rubeus
 */
public class ConnexionControleur extends AbstractControleur {

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
        
        String lien = request.getServletPath();
        
        switch (lien) {
            case "/ConnexionControleur":
                try {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/ConnexionControleur.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }   break;
            case "/Login":
                ClientDB clientDB = new ClientDB();
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                
                int etat = clientDB.isClient(email, password);
                switch(etat){
                    case ClientDB.IS_CLIENT:
                        Client existingClient = clientDB.get(email);
                        session.setAttribute("client", existingClient);
                        callServlet(request, response, "/Confirmation");
                        break;
                    case ClientDB.NOT_EXIST:
                        callServlet(request, response, "/Enregistrer");
                        break;
                    case ClientDB.WRONG_PASSWORD:
                        try {
                            this.getServletContext().getRequestDispatcher("/WEB-INF/ConnexionControleur.jsp").forward(request, response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        }   break;
                    default: 
                        try {
                            this.getServletContext().getRequestDispatcher("/WEB-INF/ConnexionControleur.jsp").forward(request, response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        }   break;
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

    
    public void callServlet(HttpServletRequest request, HttpServletResponse response, String servlet) throws ServletException, IOException {
        ServletContext context= getServletContext();
        RequestDispatcher rd= context.getRequestDispatcher(servlet);
        rd.forward(request, response);
    }
}
