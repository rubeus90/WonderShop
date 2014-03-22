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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkgEntities.Article;
import pkgEntities.Categorie;

/**
 *
 * @author rubeus
 */
public class CategorieDB extends ManagerDB{
    
    public CategorieDB(){
        super.connection();
    }
    
    public Categorie get(int id){
        Categorie categorie = new Categorie();
        
        Statement statement;
        try {
            statement = connexion.createStatement();
            String string = "SELECT NOM FROM CATEGORIE WHERE ID="+id;
            ResultSet resultat = statement.executeQuery(string);
            resultat.next();

            String nom = resultat.getString("NOM");

            categorie.setNom(nom);
            categorie.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(CategorieDB.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return categorie;
    }
    
    public Categorie get(String nom){
        Categorie categorie = new Categorie();
        int id = 0;
        
        Statement statement;
        try {
            statement = connexion.createStatement();
            String string = "SELECT ID FROM CATEGORIE WHERE NOM='"+nom+"'";
            ResultSet resultat = statement.executeQuery(string);
            resultat.next();

            id = resultat.getInt("ID");
            
            categorie.setId(id);
            categorie.setNom(nom);
        } catch (SQLException ex) {
            Logger.getLogger(CategorieDB.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return categorie;
    }
    
    public List<Article> getListArticle(Categorie categorie){
        List<Article> listArticle = new ArrayList<Article>();
        
        int idCategorie = categorie.getId();
        String query = "SELECT ID,NOM,DESCRIPTION,PRIX,QUANTITE,URL_IMAGE,DATE_CREATION FROM ARTICLE WHERE ID_CATEGORIE="+idCategorie;
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(query);
            while(resultat.next()){
                int id = resultat.getInt("ID");
                String nom = resultat.getString("NOM");
                String description = resultat.getString("DESCRIPTION");
                String prix = resultat.getString("PRIX");
                String quantite = resultat.getString("QUANTITE");
                String urlImage = resultat.getString("URL_IMAGE");
                String dateCreation = resultat.getString("DATE_CREATION");
                
                Article article = new Article();
                article.setId(id);
                article.setNom(nom);
                article.setDescription(description);
                article.setPrix(prix);
                article.setQuantite(quantite);
                article.setUrl_image(urlImage);
                article.setDate_creation(dateCreation);
                
                listArticle.add(article);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(CategorieDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listArticle;
    }
}
