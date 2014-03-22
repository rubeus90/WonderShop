/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgDbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public ClientDB(){
        super.connection();
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
    
    public Client get(String email){
        Client client = new Client();
        try {
            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery( "SELECT ID,NOM,PRENOM,TELEPHONE,ADRESSE,CODE_POSTAL,VILLE,DATE_CREATION FROM CLIENT WHERE EMAIL='"+email+"'");
            resultat.next();
            int id = resultat.getInt("ID");
            String nom = resultat.getString("NOM");
            String prenom = resultat.getString("PRENOM");
            String tel = resultat.getString("TELEPHONE");  
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
            String password = client.getPassword();
            
            String query = "INSERT INTO CLIENT(NOM,PRENOM,TELEPHONE,EMAIL,ADRESSE,CODE_POSTAL,VILLE,DATE_CREATION,PASSWORD) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, tel);
            statement.setString(4, email);
            statement.setString(5, adresse);
            statement.setString(6, codePostal);
            statement.setString(7, ville);
            statement.setString(8, dateCreation);
            statement.setString(9, password);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isClient(String email, String password){
        String query = "SELECT PASSWORD FROM CLIENT WHERE EMAIL='"+email+"'";
        Statement statement;
        try {
            statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(query);
            resultat.next();
            String passwordDB = resultat.getString("PASSWORD");
            return passwordDB.equals(password);
        } catch (SQLException ex) {
            Logger.getLogger(ClientDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}