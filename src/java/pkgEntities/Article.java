/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgEntities;

/**
 *
 * @author rubeus
 */
public class Article {

    private String nom;
    private String description;
    private String prix;
    private String quantite;
    private String url_image;
    private String date_creation;
    private Categorie id_categorie;

    public Article(String nom, String description, String prix, String quantite, String url_image, String date_creation, Categorie id_categorie) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.url_image = url_image;
        this.date_creation = date_creation;
        this.id_categorie = id_categorie;
    }

    public Article() {
        this.nom = "null";
        this.description = "null";
        this.prix = "null";
        this.quantite = "null";
        this.url_image = "null";
        this.date_creation = "null";
        this.id_categorie = null;
    }
    
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getPrix() {
        return prix;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getUrl_image() {
        return url_image;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public Categorie getId_categorie() {
        return id_categorie;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setId_categorie(Categorie id_categorie) {
        this.id_categorie = id_categorie;
    }
    
}
