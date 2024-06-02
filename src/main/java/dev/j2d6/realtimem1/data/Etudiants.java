package dev.j2d6.realtimem1.data;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//@XmlRootElement(name = "Eleves")
public class Etudiants {

    public List<Etudiant> eleves ;

    //@XmlElement(name = "Etudiant")
    public List<Etudiant> getEleves() {
        return eleves;
    }

    public void setEleves(List<Etudiant> eleves) {
        this.eleves = eleves;
    }

    public Etudiants(List<Etudiant> eleves) {
        this.eleves = eleves;
    }
}
