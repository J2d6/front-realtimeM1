package dev.j2d6.realtimem1.utilities.xmlFeatures;

import dev.j2d6.realtimem1.data.Etudiant;
import dev.j2d6.realtimem1.data.Etudiants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    public JAXBContext jaxbContext;
    public Marshaller marshaller;
    public Unmarshaller unmarshaller;



    public void factory () {
        try {
            jaxbContext = JAXBContext.newInstance(Etudiant.class, Etudiants.class);
            marshaller = jaxbContext.createMarshaller();
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *Unmarshall all instances already in file param
     *
     * @param file an existing xml file
     * @return Etudiants : instance of Etudiants class. Contains a "eleves" attribute
     */

    public Etudiants unmarshalAll (File file) throws JAXBException, IOException {
        if (file == null || !file.exists() || file.length() == 0) {
            throw new FileNotFoundException("Le fichier est introuvable ou vide");
        }

        return   (Etudiants) this.unmarshaller.unmarshal(file);


    }

    public Etudiants marshallAll (Etudiants etudiantList, File xmlFile) {

        try {

            //list.eleves.addAll(etudiantList);
            marshaller.marshal(etudiantList, xmlFile);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return etudiantList;
    }
    public Etudiant marshal (Etudiant etudiant, File file) {

        Etudiants list = new Etudiants(null);

        if (file == null || !file.exists() || file.length() == 0) {
           //
            List<Etudiant> studentList = new ArrayList<Etudiant>(List.of(etudiant));
            list = new Etudiants(studentList);
        } else {
            try {
                list = unmarshalAll(file);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            list.getEleves().add(etudiant);
        }

        marshallAll(list, file);
        return etudiant;

    }

}
