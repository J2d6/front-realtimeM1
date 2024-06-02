package dev.j2d6.realtimem1.ui.screens;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class InputEmptyDialog {
    public static void display () {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setTitle("AVERTISSEMENT");

        //layout
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(25));

        Text text = new Text("Tous les champs doivent être remplis !");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        layout.getChildren().add(text);

        Scene scene = new Scene(layout);
        stage.setScene(scene);

        stage.showAndWait();

    }
}
