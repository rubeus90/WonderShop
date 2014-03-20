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
import pkgEntities.Categorie;

/**
 *
 * @author rubeus
 */
public class CategorieDB extends ManagerDB{
    private Connection connexion;
    
    public CategorieDB(){
        connexion = super.connection();
    }
    
    public Categorie get(int id){
        Categorie categorie = new Categorie();
        
        Statement statement;
        try {
            statement = connexion.createStatement();
            String string = "SELECT NOM FROM CATEGORIE WHERE ID='"+id+"'";
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
}
