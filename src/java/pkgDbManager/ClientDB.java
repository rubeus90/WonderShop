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
import pkgEntities.Client;

/**
 *
 * @author rubeus
 */
public class ClientDB extends ManagerDB{
    private Connection connexion;
    
    public ClientDB(){
        connexion = super.connection();
    }
    
    public Client get(int id){
        Client client = new Client();
        try {
            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery( "SELECT NOM,PRENOM,TELEPHONE,EMAIL,ADRESSE,CODE_POSTAL,VILLE,DATE_CREATION FROM CLIENT WHERE ID='"+id+"'");
            resultat.next();
            String nom = resultat.getString("NOM");
            String prenom = resultat.getString("PRENOM");
            String tel = resultat.getString("TELEPHONE");  
            String email = resultat.getString("EMAIL");
            String adresse = resultat.getString("ADRESSE");
            String codePostal = resultat.getString("CODE_POSTAL");
            String ville = resultat.getString("VILLE");
            String dateCreation = resultat.getString("DATE_CREATION");
            
            client.setId(id);
            client.setNom(nom);
            client.setPrenom(prenom);
            client.setEmail(email);
            client.setTelephone(tel);
            client.setAdresse(adresse);
            client.setCodePostal(codePostal);
            client.setVille(ville);
            client.setDateCreation(dateCreation);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return client;
    }
    
    public void add(Client client){
        try {
            String nom = client.getNom();
            String prenom = client.getPrenom();
            String email = client.getEmail();
            String tel = client.getTelephone();
            String adresse = client.getAdresse();
            String codePostal = client.getCodePostal();
            String ville = client.getVille();
            String dateCreation = client.getDateCreation();
            
            String string = "INSERT INTO CLIENT(NOM,PRENOM,TELEPHONE,EMAIL,ADRESSE,CODE_POSTAL,VILLE,DATE_CREATION) VALUES ('"+nom+"','"+prenom+"','"+tel+"','"+email+"','"+adresse+"','"+codePostal+"','"+ville+"','"+dateCreation+"')";
            Statement statement = connexion.createStatement();
            statement.executeUpdate(string);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}