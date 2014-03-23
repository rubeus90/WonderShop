package pkgControleur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgDbManager.ClientDB;
import pkgFormManager.Enregistrer;

public class EnregistrerControleur extends AbstractControleur{

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
            case "/EnregistrerControleur":
                try {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/EnregistrerControleur.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }   break;
            case "/ClientEnregistre":
                Enregistrer enregistrer = new Enregistrer();
                int verification = enregistrer.verification(request);
                
                switch(verification){
                    case Enregistrer.ALL_OK:
                        //Hydrater l'objet Client et mettre le client dans la session
                        client = enregistrer.hydrate(request);
                        //Mettre le client dans le BDD
                        ClientDB clientDB = new ClientDB();
                        clientDB.add(client);
                        //Recuperer le client dans la BDD (pour avoir l'ID) puis le mettre dans la session
                        String email = client.getEmail();
                        client = clientDB.get(email);
                        session.setAttribute("client", client);
                        callServlet(request, response, "/Confirmation");
                        break;
                    case Enregistrer.EMAIL_ALREADY_EXIST:
                        session.setAttribute("text", "L'email que vous avez choisi existe déjà");
                        try {
                            this.getServletContext().getRequestDispatcher("/WEB-INF/EnregistrerControleur.jsp").forward(request, response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        }
                        break;
                    case Enregistrer.PASSWORD_NOT_MATCH:
                        session.setAttribute("text", "Les mots de passe ne correspondent pas");
                        try {
                            this.getServletContext().getRequestDispatcher("/WEB-INF/EnregistrerControleur.jsp").forward(request, response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        try {
                            this.getServletContext().getRequestDispatcher("/WEB-INF/EnregistrerControleur.jsp").forward(request, response);
                        } catch (ServletException e) {
                            e.printStackTrace();
                        }
                }
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
