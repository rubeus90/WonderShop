/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgControleur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgEntities.Client;

/**
 *
 * @author JM
 */
@WebServlet(name = "MainControleur", urlPatterns = {"/MainControleur"})
public class MainControleur extends AbstractControleur {
    
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
        response.setContentType("text/html;charset=UTF-8");
        
        session = request.getSession();
        client = (Client) session.getAttribute("client");
        
        String path = request.getServletPath();
        
        
        if(path.contains("/Article")) {
            path.replaceAll("/Article/", "");
            session.setAttribute("article", path);
            session.setAttribute("action", "Ajouter");
            callServlet(request, response, "/IndexControleur");
        }
        else if(path.contains("/Categorie")) {
            path.replaceAll("/Categorie/", "");
            session.setAttribute("categorie", path);
            callServlet(request, response, "/CategorieControleur");
        }
        else if(path.equals("/EnregistrerClient")) {
            callServlet(request, response, "/EnregistrerControleur");
        }
        else if(path.equals("/Confirmation")) {
            callServlet(request, response, "/AchatControleur");
        }
        else {
            callServlet(request, response, "/IndexControleur");
        }
        
//        /* Si un client est connecté */
//        if(client!=null) {
//            /* Première page */
//            if(direction == null) {
//                callServlet(request, response, "/IndexControleur");
//            }
//            else {
//                callServlet(request, response, "/"+direction);
//            }
//        }
//        else {
//            callServlet(request, response, "/IndexControleur");
//        }
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
