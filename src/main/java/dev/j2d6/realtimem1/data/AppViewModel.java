//package dev.j2d6.realtimem1.data;
//
//import dev.j2d6.realtimem1.utilities.XmlParser;
//import javafx.collections.ObservableList;
//
//import java.io.File;
//
//public class AppViewModel {
//    private XmlParser xmlParser = null;
//    private ObservableList<Etudiant> etudiantsListPropertyInXml = null;
//    private ObservableList<Etudiant> getEtudiantsListPropertyInDB = null;
//    private ObservableList<Etudiant> etudiantsList = null ;
//
//
//    File xmlFileData;
//
//   // CONSTRUCTOR
//    public AppViewModel () {
//        this.xmlParser = new XmlParser();
//        this.xmlFileData = new File("data.xml");
//    }
//
//
//    // GETTERS and SETTERS
//    public ObservableList<Etudiant> getEtudiantsList() {
//        return etudiantsList;
//    }
//
//    public void setEtudiantsList(ObservableList<Etudiant> etudiantsList) {
//        this.etudiantsList = etudiantsList;
//    }
//
//    public XmlParser getXmlParser() {
//        return xmlParser;
//    }
//
//    public void setXmlParser(XmlParser xmlParser) {
//        this.xmlParser = xmlParser;
//    }
//
//    public ObservableList<Etudiant> getEtudiantsListPropertyInXml() {
//        return etudiantsListPropertyInXml;
//    }
//
//    public void setEtudiantsListPropertyInXml(ObservableList<Etudiant> etudiantsListPropertyInXml) {
//        this.etudiantsListPropertyInXml = etudiantsListPropertyInXml;
//    }
//
//    public ObservableList<Etudiant> getGetEtudiantsListPropertyInDB() {
//        return getEtudiantsListPropertyInDB;
//    }
//
//    public void setGetEtudiantsListPropertyInDB(ObservableList<Etudiant> getEtudiantsListPropertyInDB) {
//        this.getEtudiantsListPropertyInDB = getEtudiantsListPropertyInDB;
//    }
//
//    //CRUD
//    public void addEtudiant() {
//        // CHECK FOR CONNECTION FIRST
//
//    }
//    public void deleteEtudiant () {
//
//    }
//    public void modifyEtudiant () {
//
//    }
//
//
//    /**
//     * Init the App ViewModel
//     */
//    public void init () {
//        // Get all in DB -> etudiantsListInDB **TASK AND UPDATE UI AFTER**
//
//        // Get all inxml -> etudiantsListInXML **NOT TASK BUT DISPLAY FIRST**
//        Etudiants etudiantsListInXMLWrapper = xmlParser.unmarshalAll(xmlFileData);
//        etudiantsListPropertyInXml.addAll(
//                etudiantsListInXMLWrapper.eleves.isEmpty() ?
//                        etudiantsListInXMLWrapper.eleves : null
//        );
//
//        etudiantsList.addAll(etudiantsListPropertyInXml);
//    }
//}
