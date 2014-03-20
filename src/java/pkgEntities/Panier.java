/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgEntities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rubeus
 */
public class Panier extends Entities{
    
    List<Article> articleList;

    public Panier() {
        articleList = new ArrayList<Article>();
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
    
    public void addArticle(Article pArticle) {
        articleList.add(pArticle);
    }
}
