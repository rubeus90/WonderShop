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
        
        
        switch(path){
            case "/IndiePop":
                session.setAttribute("categorie", "IndiePop");
                callServlet(request, response, "/CategorieControleur"); break;
            case "/PopRock":
                session.setAttribute("categorie", "PopRock");
                callServlet(request, response, "/CategorieControleur"); break;
            case "/PunkRock":
                session.setAttribute("categorie", "PunkRock");
                callServlet(request, response, "/CategorieControleur"); break;
            case "/Alternatif":
                session.setAttribute("categorie", "Alternatif");
                callServlet(request, response, "/CategorieControleur"); break;
            case "/Panier":
                callServlet(request, response, "/PanierControleur"); break;
            default: callServlet(request, response, "/IndexControleur");
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
