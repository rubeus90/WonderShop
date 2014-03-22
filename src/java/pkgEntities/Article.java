/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgEntities;

import java.util.Objects;

/**
 *
 * @author rubeus
 */
public class Article extends Entities{

    private int id;
    private String artiste;
    private String album;
    private String prix;
    private String url_image;
    private String date_creation;
    private Categorie categorie;
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null) 
            return false;
        else if(obj instanceof Article) {
            Article article = (Article)obj;
            
            if(article.getId() == (id)) { // Par pitié, on compare des clé primaires qui sont par définition UNIQUE
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.artiste);
        return hash;
    }
    
    public String getArtiste() {
        return artiste;
    }

    public String getAlbum() {
        return album;
    }

    public String getPrix() {
        return prix;
    }
    
    public double getPrix_double() {
        return Double.parseDouble(prix);
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setArtiste(String artiste) {
        //if(stringValid(nom)){
            this.artiste = artiste;
        //}
    }

    public void setAlbum(String album) {
//        if(stringValid(description)){
            this.album = album;
//        }
    }

    public void setPrix(String prix) {
        if(intValid(prix)){
            this.prix = prix;
        }        
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}