package dev.j2d6.realtimem1.utilities.EtudiantFeatures;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.data.Etudiant;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class DeleteEtudiant {
    AppViewModel state;

    public DeleteEtudiant(AppViewModel state) {
        this.state = state;
    }

    public void delete(Etudiant etudiant) {
        if (this.state.getConnexionStatus()) {
            // Connexion OK
            System.out.println("CONNEXION OK... DELETING ...");
            this.state.getEtudiantsList().remove(etudiant);
        } else {
            // Connexion not OK
            ButtonType okButton = new ButtonType("OK");
            ButtonType cancelButton = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.ERROR, "Voulez-vous continuer ?", okButton, cancelButton);
            alert.setTitle("Problème de connection ");
            alert.setHeaderText("Impossible de supprimer !");
            alert.setContentText("Erreur de connexion à la base de données");
            alert.showAndWait();

        }
    }
}
