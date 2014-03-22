/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgDbManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    public CommandeDB(){
        super.connection();
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
        
        String query = "INSERT INTO COMMANDE(ID_CLIENT,ID_ARTICLE) VALUES (?,?)";
        PreparedStatement statement;
        try {
            statement = connexion.prepareStatement(query);
            statement.setInt(1, idClient);
            statement.setInt(2, idArticle);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDB.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public List<Article> getListArticle(List<Commande> listCommande){
        List<Article> listArticle = new ArrayList<>();
        
        for(Commande commande : listCommande){
            Article article = commande.getArticle();
            listArticle.add(article);
        }
        
        return listArticle;
    }
}
