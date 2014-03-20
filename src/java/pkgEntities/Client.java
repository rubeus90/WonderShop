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
public class Client extends Entities{
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private String codePostal;
    private String ville;
    private String dateCreation;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(stringValid(nom)){
            this.nom = nom;
        }        
    }
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if(stringValid(prenom)){
            this.prenom = prenom;
        }        
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if(intValid(telephone)){
            this.telephone = telephone;
        }        
    }
    
    public void setEmail(String email) {
        if(emailValid(email))
            this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        if(adresseValid(adresse)){
            this.adresse = adresse;
        }        
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        if(intValid(codePostal)){
            this.codePostal = codePostal;
        }        
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        if(stringValid(ville)){
            this.ville = ville;
        }        
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }    
}
