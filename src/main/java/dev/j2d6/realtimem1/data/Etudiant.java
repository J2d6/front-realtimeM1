package dev.j2d6.realtimem1.data;

public class Etudiant {
    private String matricule;
    private String nom;
    private String adresse ;
    private int bourse;

    public Etudiant(String matricule, String nom, String adresse, int bourse) {
        this.matricule = matricule;
        this.nom = nom;
        this.adresse = adresse;
        this.bourse = bourse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getBourse() {
        return bourse;
    }

    public void setBourse(int bourse) {
        this.bourse = bourse;
    }
}
