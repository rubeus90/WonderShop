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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public List<Commande> get(int id){
        ClientDB clientDB = new ClientDB();
        ArticleDB articleDB = new ArticleDB();
        
        List<Commande> listCommande = new ArrayList<Commande>();
        
        Statement statement;
        try {
            statement = connexion.createStatement();
            String string = "SELECT ID_CLIENT,ID_ARTICLE, QUANTITE, DATE_CREATION FROM COMMANDE WHERE ID_CLIENT="+id;
            ResultSet resultat = statement.executeQuery(string);
         
            while(resultat.next()){
                Commande commande = new Commande();
                
                int idClient = resultat.getInt("ID_CLIENT");
                int idArticle = resultat.getInt("ID_ARTICLE");
                int quantite = resultat.getInt("QUANTITE");
                String date = resultat.getString("DATE_CREATION");

                commande.setClient(clientDB.get(idClient));
                commande.setArticle(articleDB.get(idArticle));
                commande.setQuantite(quantite);
                commande.setDateCreation(date);
                
                listCommande.add(commande);
            } 
        } 
        catch (SQLException ex) {
            Logger.getLogger(CommandeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listCommande;
    }
    
    public void add(Commande commande){
        Client client = commande.getClient();
        Article article = commande.getArticle();
        int quantite = commande.getQuantite();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateCreation = dateFormat.format(date);
        
        int idClient = client.getId();
        int idArticle = article.getId();
        
        String query = "INSERT INTO COMMANDE(ID_CLIENT,ID_ARTICLE,QUANTITE,DATE_CREATION) VALUES (?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = connexion.prepareStatement(query);
            statement.setInt(1, idClient);
            statement.setInt(2, idArticle);
            statement.setInt(3, quantite);
            statement.setString(4, dateCreation);
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
