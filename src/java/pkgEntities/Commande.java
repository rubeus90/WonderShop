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
public class Commande {
    private Client client;
    private Article article;
    private int quantite;
    private String date_creation;
    private int idCommande;
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Article getArticle() {
        return article;
    }
    
    public String getDateCreation(){
        return date_creation;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public void setDateCreation(String date){
        this.date_creation = date;
    }
    
    public int getIdCommande(){
        return idCommande;
    }
    
    public void setIdCommande(int id){
        this.idCommande = id;
    }
    
}
