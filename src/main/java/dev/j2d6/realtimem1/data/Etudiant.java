package dev.j2d6.realtimem1.data;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Etudiant {
    private String matricule;
    private String nom;
    private String adresse;
    private int bourse;

    // Constructeur sans argument par défaut
    public Etudiant() {
    }

    public Etudiant(String matricule, String nom, String adresse, int bourse) {
        this.matricule = matricule;
        this.nom = nom;
        this.adresse = adresse;
        this.bourse = bourse;
    }

    @XmlElement
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlElement
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @XmlElement
    public int getBourse() {
        return bourse;
    }

    public void setBourse(int bourse) {
        this.bourse = bourse;
    }
}
