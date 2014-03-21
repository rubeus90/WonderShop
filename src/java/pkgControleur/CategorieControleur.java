package pkgControleur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        
        switch(path){
                case "IndiePop":
                    session.setAttribute("categorie", "IndiePop");
                    callServlet(request, response, "/CategorieControleur"); break;
                case "PopRock":
                    session.setAttribute("categorie", "PopRock");
                    callServlet(request, response, "/CategorieControleur"); break;
                case "PunkRock":
                    session.setAttribute("categorie", "PunkRock");
                    callServlet(request, response, "/CategorieControleur"); break;
                case "Alternatif":
                    session.setAttribute("categorie", "Alternatif");
                    callServlet(request, response, "/CategorieControleur"); break;
            
                default: callServlet(request, response, "/IndexControleur");
            }
//        Categorie categorie = n
//        
//        try {
//            this.getServletContext().getRequestDispatcher("/CategorieControleur.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
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
