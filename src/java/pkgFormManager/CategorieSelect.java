package pkgFormManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pkgEntities.Categorie;

/**
 *
 * @author rubeus
 */
public class CategorieSelect {
    
    public Categorie hydrate(HttpServletRequest request){
        Categorie categorie = new Categorie();
        
        HttpSession session = request.getSession();
        String nom = (String) session.getAttribute("categorie");
        
        categorie.setNom(nom);
        
        return categorie;
    }
}
