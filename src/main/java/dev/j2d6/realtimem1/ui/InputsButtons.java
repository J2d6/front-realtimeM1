package dev.j2d6.realtimem1.ui;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.data.Etudiant;
import dev.j2d6.realtimem1.ui.screens.InputEmptyDialog;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

public class InputsButtons extends VBox {
    private Button addButton ;
    private Button cancelButton;
    public AppViewModel state;
    public InputRow inputRow;

    public InputsButtons(double v, Node... nodes) {
        super(v, nodes);
    }

    public InputsButtons(Node... nodes) {
        super(nodes);
    }

    public InputsButtons(double v, AppViewModel state, InputRow inputRow) {
        super(v);
        this.state = state;
        this.inputRow = inputRow;
    }

    public InputsButtons( AppViewModel state, InputRow inputRow) {
        super();
        this.state = state;
        this.inputRow = inputRow ;
    }
    public void resetAllInputs () {
        this.inputRow.namesInput.setText("");
        this.inputRow.bourseInput.setText("");
        this.inputRow.addressInput.setText("");
        this.inputRow.matriculeInput.setText("");
    }

    public void mount() {
        addButton = new Button("Ajouter");
        addButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        cancelButton = new Button("Annuler");
        cancelButton.setStyle("-fx-background-color: yellow; -fx-text-fill: black;");

        this.getChildren().addAll(addButton, cancelButton);
        this.setAlignment(Pos.CENTER);

        this.cancelButton.setOnAction(
                e -> this.resetAllInputs()
        );
        this.addButton.setOnAction(
                e -> {
                        if (
                                state.nameStringProperty.get().isEmpty() ||
                                state.bourseStringProperty.get().isEmpty() ||
                                state.matriculeStringProperty.get().isEmpty() ||
                                state.adressStringPRoperty.get().isEmpty()
                        ) {
                            ButtonType okButton = new ButtonType("OK");
                            ButtonType cancelButton = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);

                            Alert alert = new Alert(Alert.AlertType.ERROR, "Voulez-vous continuer ?", okButton, cancelButton);
//                            alert.setTitle("");
                            alert.setHeaderText("Tous les champs doivent être remplis !");
                            alert.setContentText("");
                            alert.showAndWait();
                        } else  {
                            state.addEtudiant(
                                state.nameStringProperty.get(),
                                Integer.parseInt(state.bourseStringProperty.get()),
                                state.adressStringPRoperty.get(),
                                state.matriculeStringProperty.get()
                            );
                            this.resetAllInputs();
                        }
                }
        );

    }
}