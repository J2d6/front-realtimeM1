package dev.j2d6.realtimem1.ui;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.ui.screens.ModifyStudentScreen;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ModifyOrDeleteButtonsRow extends HBox {
    private Button deleteButton;
    private Button modifyButton;
    public AppViewModel state;

    public ModifyOrDeleteButtonsRow(double v, AppViewModel state) {

        super(v);
        this.state = state;
    }

    public void mount () {
        deleteButton = new Button("Supprimer");
        deleteButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");

        modifyButton = new Button("Modifier");
        modifyButton.setStyle("-fx-background-color: #0061D3; -fx-text-fill: white;");

        this.getChildren().addAll(
                modifyButton,
                deleteButton
        );

        modifyButton.setOnAction(
                e -> {
                    ModifyStudentScreen.display(state.selectedStudentProperty);
                }
        );
    }

}
