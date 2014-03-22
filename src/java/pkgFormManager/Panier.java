/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgFormManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pkgEntities.Article;
import pkgEntities.Client;
import pkgEntities.Commande;
import pkgEntities.Entities;

/**
 *
 * @author rubeus
 */
public class Panier extends Entities {
    
    private HashMap<Article,Integer> map;

    public Panier() {
        if(map==null)
            map = new HashMap<Article,Integer>();
    }

    public HashMap<Article,Integer> getMap() {
        return map;
    }
    
    public void removeAllArticle(Article pArticle) {
        if(map.containsKey(pArticle)) {
            map.remove(pArticle);
        }
    }
    
    public void removeArticle(Article pArticle) {
        if(map.containsKey(pArticle)) {
            int effectif = map.get(pArticle);
            if(effectif==1)
                map.remove(pArticle);
            else {
                map.remove(pArticle);
                map.put(pArticle,effectif-1);
            }
        }
    }
    
    public void addArticle(Article pArticle) {
        
        if(map.size()!=0) {
            if(map.containsKey(pArticle)) {
                int effectif = map.get(pArticle) + 1;
                map.put(pArticle,effectif);
            }
            else
                map.put(pArticle,1);
        } 
        else
            map.put(pArticle,1);
    }
    
    public String getPrix() {
        int prix = 0;
        for(Article article : map.keySet()) {
            if(article.getPrix()!=null)
                prix += map.get(article)*article.getPrix_double();
        }
        return ""+prix;
    }
    
    public int getEffectif() {
        int eff = 0;
        for(Article article:map.keySet()) {
            eff += map.get(article);
        }
        return eff;
    }
    
    public Article getArticle(String pnom) {
        for(Article article : map.keySet()) {
            if(pnom.equals(article.getArtiste())) {
                return article;
            }
        }
        return null;
    }
    
    public List<Commande> getCommande(Client client) {
        List<Commande> listCommande = new ArrayList<Commande>();
        int j = 1;
        for(Article article : map.keySet()) {
            for(int i=0; i < map.get(article);i++) {
                Commande com = new Commande();
                com.setClient(client);
                com.setArticle(article);
                listCommande.add(com);
                j++;
            }
        }
        return listCommande;
    }
    
    public void savePanier() {
        
        
        
    }
}