package dev.j2d6.realtimem1.ui.screens;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.data.Etudiant;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class ModifyStudentScreen {
    public static  void display (Etudiant student) {
        Stage stage = new Stage();
        stage.setTitle("Modifier");
        stage.initModality(Modality.APPLICATION_MODAL);


        //layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        //Uis
        TextField nameInput = new TextField(student.getNom());
        nameInput.setPromptText("NOM et Prénom(s)");

        TextField matriculeInput = new TextField(student.getMatricule());
        matriculeInput.setPromptText("Matricule");

        TextField adressInput = new TextField(student.getAdresse());
        adressInput.setPromptText("Adresse");

        TextField bourseInput = new TextField(""+student.getBourse());
        bourseInput.setPromptText("Bourse");

        layout.getChildren().addAll(
                matriculeInput,
                nameInput,
                adressInput,
                bourseInput
        );

        HBox buttonLayout = new HBox(5);
        buttonLayout.setPadding(new Insets(15));
        Button cancelButton = new Button("Annuler");
        cancelButton.setStyle("-fx-background-color: red; -fx-text-fill : white;");
        cancelButton.setOnAction(
                e -> {
                    stage.close();
                }
        );
        Button modifyButton = new Button("Modifier");
        modifyButton.setStyle("-fx-background-color : #0061D3 ; -fx-text-fill : white;");

        buttonLayout.getChildren().addAll(
                cancelButton, modifyButton
        );
        buttonLayout.setAlignment(Pos.CENTER_RIGHT);

        layout.getChildren().add(buttonLayout);

        Scene modifyScreenScene = new Scene(layout, 400, 250);
        stage.setScene(modifyScreenScene);
        stage.showAndWait();

    }
}
