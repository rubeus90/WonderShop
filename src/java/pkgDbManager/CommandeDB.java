/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgDbManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgEntities.Commande;

/**
 *
 * @author rubeus
 */
public class CommandeDB extends ManagerDB{
    private Connection connexion;
    
    public CommandeDB(){
        connexion = super.connection();
    }
    
    public Commande hydrate(int id){
        Commande commande = new Commande();
        ClientDB clientDB = new ClientDB();
        ArticleDB articleDB = new ArticleDB();
        
        Statement statement;
        try {
            statement = connexion.createStatement();
            String string = "SELECT ID_CLIENT,ID_ARTICLE FROM COMMANDE WHERE ID='"+id+"'";
            ResultSet resultat = statement.executeQuery(string);
            resultat.next();
            int idClient = resultat.getInt("ID_CLIENT");
            int idArticle = resultat.getInt("ID_ARTICLE");
            
            commande.setArticle(articleDB.hydrate(idArticle));
            commande.setClient(clientDB.hydrate(idClient));
        } 
        catch (SQLException ex) {
            Logger.getLogger(CommandeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return commande;
    }
}
