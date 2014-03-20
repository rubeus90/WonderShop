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

/**
 *
 * @author rubeus
 */
public class ArticleDB extends ManagerDB{
    private Connection connexion;
    
    public ArticleDB(){
        connexion = super.connection();
    }
    
    public Article hydrate(int id){
        Article article = new Article();
        CategorieDB categorieDB = new CategorieDB();
        
        try {  
            Statement statement = connexion.createStatement();
            String string = "SELECT NOM,DESCRIPTION,PRIX,QUANTITE,URL_IMAGE,DATE_CREATION,ID_CATEGORIE WHERE ID='"+id+"'";
            ResultSet resultat = statement.executeQuery(string);
            resultat.next();
            String nom = resultat.getString("NOM");
            String description = resultat.getString("DESCRIPTION");
            String prix = resultat.getString("PRIX");
            String quantite = resultat.getString("QUANTITE");
            String urlImage = resultat.getString("URL_IMAGE");
            String dateCreation = resultat.getString("DATE_CREATION");
            int idCategorie = resultat.getInt("ID_CATEGORIE");
            
            article.setNom(nom);
            article.setDescription(description);
            article.setPrix(prix);
            article.setQuantite(quantite);
            article.setUrl_image(urlImage);
            article.setDate_creation(dateCreation);
            article.setCategorie(categorieDB.hydrate(idCategorie));
        } 
        catch (SQLException ex) {
            Logger.getLogger(ArticleDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return article;
    }
}
