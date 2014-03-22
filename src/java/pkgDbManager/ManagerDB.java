/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgDbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rubeus
 */
public class ManagerDB {
    protected Connection connexion;
    
    public void connection(){
        //Connection connexion = null;
        /* Chargement du driver JDBC */
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        
        /* Connexion à la base de données */
        String url = "jdbc:derby://localhost:1527/ecommerce";
        String utilisateur = "ecommerce";
        String motDePasse = "ecommerce";
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        } 
    }
}
