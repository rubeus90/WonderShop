/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgEntities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rubeus
 */
public class Panier extends Entities{
    
    private HashMap<Article,Integer> map;

    public Panier() {
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
                map.put(pArticle,effectif+1);
            }
        }
    }
    
    public void addArticle(Article pArticle) {
        if(map.containsKey(pArticle)) {
            int effectif = map.get(pArticle) + 1;
            map.remove(pArticle);
            map.put(pArticle,effectif);
        }
        else
            map.put(pArticle,1);
    }
    
    public String getPrix() {
        int prix = 0;
        for(Article article : map.keySet()) {
            //prix += map.get(article)*article.get;
        }
        
        return ""+prix;
    }
}
