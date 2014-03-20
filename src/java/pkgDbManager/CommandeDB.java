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
import pkgEntities.Article;
import pkgEntities.Client;
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
    
    public Commande get(int id){
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
            
            commande.setArticle(articleDB.get(idArticle));
            commande.setClient(clientDB.get(idClient));
        } 
        catch (SQLException ex) {
            Logger.getLogger(CommandeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return commande;
    }
    
    public void add(Commande commande){
        Client client = commande.getClient();
        Article article = commande.getArticle();
        
        int idClient = client.getId();
        int idArticle = article.getId();
        
        String string = "INSERT INTO COMMANDE(ID_CLIENT,ID_ARTICLE) VALUES ("+idClient+","+idArticle+"')";
        Statement statement;
        try {
            statement = connexion.createStatement();
            statement.executeUpdate(string);
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDB.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
