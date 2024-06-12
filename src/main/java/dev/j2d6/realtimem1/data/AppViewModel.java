package dev.j2d6.realtimem1.data;

import dev.j2d6.realtimem1.utilities.XmlParser;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;


public class AppViewModel {

    private XmlParser xmlParser ;
    private ObservableList<Etudiant> etudiantsListPropertyInXml ;
    private ObservableList<Etudiant> getEtudiantsListPropertyInDB ;
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
        this.xmlParser = new XmlParser();
        this.xmlFileData = new File("data.xml");
        this.nameStringProperty = new SimpleStringProperty("");
        this.adressStringPRoperty = new SimpleStringProperty("");
        this.matriculeStringProperty = new SimpleStringProperty("");
        this.bourseStringProperty = new SimpleStringProperty("");
        this.etudiantsList = FXCollections.observableArrayList();
        this.connectionStatusProperty = new SimpleBooleanProperty(true);

    }


    // GETTERS and SETTERS
    public ObservableList<Etudiant> getEtudiantsList() {
        return etudiantsList;
    }

    public void setEtudiantsList(ObservableList<Etudiant> etudiantsList) {
        this.etudiantsList = etudiantsList;
    }

    public XmlParser getXmlParser() {
        return xmlParser;
    }

    public void setXmlParser(XmlParser xmlParser) {
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
        Etudiants etudiantsListInXMLWrapper = xmlParser.unmarshalAll(xmlFileData);
        etudiantsListPropertyInXml.addAll(
                etudiantsListInXMLWrapper.eleves.isEmpty() ?
                        etudiantsListInXMLWrapper.eleves : null
        );

        etudiantsList.addAll(etudiantsListPropertyInXml);
    }

    public boolean getConnexionStatus() {
        return connectionStatusProperty.get();
    }

    public void setConnexionStatus (boolean connexionStatus) {
        this.connectionStatusProperty.set(connexionStatus);
    }
}
