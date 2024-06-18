package dev.j2d6.realtimem1.data;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Etudiants {
    private List<Etudiant> eleves;

    // Constructeur sans argument par défaut
    public Etudiants() {
    }

    public Etudiants(List<Etudiant> eleves) {
        this.eleves = eleves;
    }

    @XmlElement(name = "Etudiant")
    public List<Etudiant> getEleves() {
        return eleves;
    }

    public void setEleves(List<Etudiant> eleves) {
        this.eleves = eleves;
    }
}
