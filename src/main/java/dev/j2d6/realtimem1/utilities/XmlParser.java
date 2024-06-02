package dev.j2d6.realtimem1.utilities;

import dev.j2d6.realtimem1.data.Etudiant;
import dev.j2d6.realtimem1.data.Etudiants;

import javax.xml.bind.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import java.io.File;
import java.util.List;
//
public class XmlParser  {
    private JAXBContext jaxbContext;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public void factory () {
        try {
            jaxbContext = JAXBContext.newInstance(Etudiant.class);
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

    public Etudiants unmarshalAll (File file) {
        try {
            return (Etudiants) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Etudiants marshallAll (List<Etudiant> etudiantList, File xmlFile) {
        Etudiants list = new Etudiants(etudiantList);
        try {

            list.eleves.addAll(etudiantList);
            marshaller.marshal(list, xmlFile);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return list;
    }
    public Etudiant marshal (Etudiant etudiant, File xmlFile) {
        try {
            Etudiants etudiantsList = unmarshalAll(xmlFile);
            etudiantsList.eleves.add(etudiant);
            marshallAll(etudiantsList.eleves, xmlFile);
            return etudiant;
        } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }

//  public Etudiant unmarshall(Etudiant etudiant, File xmlFile) {
//
// }

}
