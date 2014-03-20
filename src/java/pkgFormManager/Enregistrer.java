package pkgFormManager;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import pkgEntities.Client;

/**
 *
 * @author rubeus
 */
public class Enregistrer {
    public Client hydrate(HttpServletRequest request){
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String adresse = request.getParameter("adresse");
        String codePostal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateCreation = dateFormat.format(date);
        
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTelephone(telephone);
        client.setEmail(email);
        client.setAdresse(adresse);
        client.setCodePostal(codePostal);
        client.setVille(ville);
        client.setDateCreation(dateCreation);
        
        return client;
    }
}
