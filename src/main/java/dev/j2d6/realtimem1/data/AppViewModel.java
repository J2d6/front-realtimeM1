package dev.j2d6.realtimem1.data;


import dev.j2d6.realtimem1.utilities.Constants;
import dev.j2d6.realtimem1.utilities.EtudiantFeatures.CreateEtudiant;
import dev.j2d6.realtimem1.utilities.xmlFeatures.XMLParser;
import jakarta.xml.bind.JAXBException;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;


public class AppViewModel {

    public XMLParser xmlParser ;
    public ObservableList<Etudiant> etudiantsListPropertyInXml ;
    public ObservableList<Etudiant> getEtudiantsListPropertyInDB ;
    public ObservableList<Etudiant> etudiantsList ;
    public StringProperty nameStringProperty ;
    public StringProperty adressStringPRoperty ;
    public StringProperty matriculeStringProperty;
    public StringProperty bourseStringProperty ;
    public Etudiant selectedStudentProperty;
    public BooleanProperty connectionStatusProperty;

    File xmlFileData;

   // CONSTRUCTOR
    public AppViewModel () {
        this.xmlParser = new XMLParser();
        this.xmlFileData = Constants.xmlFileData;
        this.nameStringProperty = new SimpleStringProperty("");
        this.adressStringPRoperty = new SimpleStringProperty("");
        this.matriculeStringProperty = new SimpleStringProperty("");
        this.bourseStringProperty = new SimpleStringProperty("");
        this.etudiantsList = FXCollections.observableArrayList();
        this.connectionStatusProperty = new SimpleBooleanProperty(false);

    }


    // GETTERS and SETTERS
    public ObservableList<Etudiant> getEtudiantsList() {
        return etudiantsList;
    }

    public void setEtudiantsList(ObservableList<Etudiant> etudiantsList) {
        this.etudiantsList = etudiantsList;
    }

    public XMLParser getXmlParser() {
        return xmlParser;
    }

    public void setXmlParser(XMLParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    public ObservableList<Etudiant> getEtudiantsListPropertyInXml() {
        return etudiantsListPropertyInXml;
    }

    public void setEtudiantsListPropertyInXml(ObservableList<Etudiant> etudiantsListPropertyInXml) {
        this.etudiantsListPropertyInXml = etudiantsListPropertyInXml;
    }

    public ObservableList<Etudiant> getGetEtudiantsListPropertyInDB() {
        return getEtudiantsListPropertyInDB;
    }

    public void setGetEtudiantsListPropertyInDB(ObservableList<Etudiant> getEtudiantsListPropertyInDB) {
        this.getEtudiantsListPropertyInDB = getEtudiantsListPropertyInDB;
    }



    //CRUD
    public void addEtudiant(
            String name,
            int bourse,
            String address,
            String matricule

    ) {
        CreateEtudiant etudiantCreator = new CreateEtudiant(this);
        etudiantCreator.create(name, address, matricule, bourse);

        this.etudiantsList.add(
                new Etudiant(
                        matricule,name,address,bourse
                )
        );
    }
    public void deleteEtudiant () {

    }
    public void modifyEtudiant () {

    }


    /**
     * Init the App ViewModel
     */
    public void init () {
        // Get all in DB -> etudiantsListInDB **TASK AND UPDATE UI AFTER**

//         Get all inxml -> etudiantsListInXML **NOT TASK BUT DISPLAY FIRST**
        this.xmlParser.factory();
        Etudiants etudiantsListInXMLWrapper = new Etudiants();
        this.etudiantsListPropertyInXml = FXCollections.observableArrayList();

        if (!(this.xmlFileData == null || !this.xmlFileData.exists() || this.xmlFileData.length() == 0)) {
            System.out.println("FICHIER NON VIDE");
            try {
                etudiantsListInXMLWrapper = xmlParser.unmarshalAll(Constants.xmlFileData);
                etudiantsListPropertyInXml.addAll (

                                etudiantsListInXMLWrapper.getEleves()
                );
            } catch (JAXBException | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("FICHIER VIDE");
        }

        etudiantsList.addAll(etudiantsListPropertyInXml);
    }

    public boolean getConnexionStatus() {
        return connectionStatusProperty.get();
    }

    public void setConnexionStatus (boolean connexionStatus) {
        this.connectionStatusProperty.set(connexionStatus);
    }
}
