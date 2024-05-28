package dev.j2d6.realtimem1.ui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class InputsButtons extends VBox {
    private Button addButton ;
    private Button cancelButton;


    public InputsButtons(double v, Node... nodes) {
        super(v, nodes);
    }

    public InputsButtons(Node... nodes) {
        super(nodes);
    }

    public InputsButtons(double v) {
        super(v);
    }

    public InputsButtons() {
        super();
    }

    public void mount() {
        addButton = new Button("Ajouter");
        addButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        cancelButton = new Button("Annuler");
        cancelButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");

        this.getChildren().addAll(addButton, cancelButton);
        this.setAlignment(Pos.CENTER);
    }
}
