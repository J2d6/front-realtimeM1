package dev.j2d6.realtimem1.utilities.EtudiantFeatures;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.data.Etudiant;
import dev.j2d6.realtimem1.utilities.Constants;

public class CreateEtudiant {
    AppViewModel state;
    public  void create(
            String nom,
            String adresse,
            String matricule,
            int bourse
    ) {
        if (this.state.getConnexionStatus()) {
            /**
             * Create query and execute it
             *
             *
             *
             */
            System.out.println("Hehehehe");
        } else {

            System.out.println(this.state.getXmlParser().marshaller);
            Etudiant etudiant = new Etudiant(matricule, nom, adresse, bourse);
            this.state.getXmlParser().marshal(etudiant, Constants.xmlFileData);
        }
    }

    public CreateEtudiant(AppViewModel state) {
        this.state = state;
    }
}
