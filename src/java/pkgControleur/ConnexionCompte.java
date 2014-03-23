package pkgControleur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgDbManager.ClientDB;
import pkgEntities.Client;

/**
 *
 * @author Martin
 */
public class ConnexionCompte extends AbstractControleur{

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
        
        session = request.getSession();
        
        if(request.getParameter("email") != null && request.getParameter("password") != null){ //On ne fait l'action que SI un formulaire a été soumis et que l'ID existe
            System.out.println("Salut !!!!");
            
            ClientDB clientDB = new ClientDB();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            int etat = clientDB.isClient(email, password);
            switch(etat){
                case ClientDB.IS_CLIENT:
                    Client existingClient = clientDB.get(email);
                    System.out.println(existingClient.getEmail());
                    session.setAttribute("CompteClient", existingClient);
                    callServlet(request, response, "/CompteControleur"); 
                    break;
                case ClientDB.NOT_EXIST:
                case ClientDB.WRONG_PASSWORD:
                    session.setAttribute("text", "Mauvais email ou mot de passe");
                    try {
                        this.getServletContext().getRequestDispatcher("/WEB-INF/CompteConnexion.jsp").forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                break;                 
            }
        }else{        
            try {
                this.getServletContext().getRequestDispatcher("/WEB-INF/CompteConnexion.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
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
