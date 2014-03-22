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

/**
 *
 * @author rubeus
 */
public class ArticleDB extends ManagerDB{
    
    public ArticleDB(){
        super.connection();
    }
    
    public Article get(int id){
        Article article = new Article();
        CategorieDB categorieDB = new CategorieDB();
        
        try {  
            Statement statement = connexion.createStatement();
            String string = "SELECT ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE FROM ARTICLE WHERE ID="+id;
            ResultSet resultat = statement.executeQuery(string);
            resultat.next();
            String artiste = resultat.getString("ARTISTE");
            String album = resultat.getString("ALBUM");
            String prix = resultat.getString("PRIX");
            String urlImage = resultat.getString("URL_IMAGE");
            String dateCreation = resultat.getString("DATE_CREATION");
            int idCategorie = resultat.getInt("ID_CATEGORIE");
            
            article.setId(id);
            article.setNom(artiste);
            article.setDescription(album);
            article.setPrix(prix);
            article.setUrl_image(urlImage);
            article.setDate_creation(dateCreation);
            article.setCategorie(categorieDB.get(idCategorie));
        } 
        catch (SQLException ex) {
            Logger.getLogger(ArticleDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return article;
    }
    
    public List<Article> getAll(){
        CategorieDB categorieDB = new CategorieDB();
        List<Article> listArticle = new ArrayList<Article>();
        
        try { 
            Statement statement = connexion.createStatement();
            String string = "SELECT ID,ARTISTE,ALBUM,PRIX,URL_IMAGE,DATE_CREATION,ID_CATEGORIE FROM ARTICLE";
            ResultSet resultat = statement.executeQuery(string);
            while(resultat.next()){
                Article article = new Article();
                int id = resultat.getInt("ID");
                String artiste = resultat.getString("ARTISTE");
                String album = resultat.getString("ALBUM");
                String prix = resultat.getString("PRIX");
                String urlImage = resultat.getString("URL_IMAGE");
                String dateCreation = resultat.getString("DATE_CREATION");
                int idCategorie = resultat.getInt("ID_CATEGORIE");

                article.setId(id);
                article.setNom(artiste);
                article.setDescription(album);
                article.setPrix(prix);
                article.setUrl_image(urlImage);
                article.setDate_creation(dateCreation);
                article.setCategorie(categorieDB.get(idCategorie));
                
                listArticle.add(article);
            }            
        } 
        catch (SQLException ex) {
            Logger.getLogger(ArticleDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listArticle;
    }
}
