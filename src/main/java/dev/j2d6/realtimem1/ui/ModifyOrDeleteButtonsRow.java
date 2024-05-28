package dev.j2d6.realtimem1.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ModifyOrDeleteButtonsRow extends HBox {
    private Button DeleteButton;
    private Button ModifyButton ;

    public ModifyOrDeleteButtonsRow(double v) {
        super(v);
    }

    public void mount () {
        DeleteButton = new Button("Supprimer");
        DeleteButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");

        ModifyButton = new Button("Modifier");
        ModifyButton.setStyle("-fx-background-color: #0061D3; -fx-text-fill: white;");

        this.getChildren().addAll(
                ModifyButton,
                DeleteButton
        );
    }

}
