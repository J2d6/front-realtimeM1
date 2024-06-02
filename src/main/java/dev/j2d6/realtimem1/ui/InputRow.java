package dev.j2d6.realtimem1.ui;

import dev.j2d6.realtimem1.data.AppViewModel;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class InputRow extends HBox {
    TextField matriculeInput;
    TextField namesInput ;
    TextField addressInput;
    TextField bourseInput ;
    InputsButtons inputsButton ;
    public AppViewModel state;


    public InputRow(
            AppViewModel state
    ) {

    }

    public InputRow(double v, Node... nodes) {
        super(v, nodes);
    }

    public InputRow(Node... nodes) {
        super(nodes);
    }

    public InputRow(double v, AppViewModel state) {
        super(v);
        this.state = state;
    }

    public void mount () {


        this.addressInput = new TextField();
        this.addressInput.setPrefWidth(250f);
        addressInput.setPromptText("Adresse");

        this.namesInput = new TextField();
        this.namesInput.setPrefWidth(250f);
        namesInput.setPromptText("NOM et Prénom(s)");

        this.bourseInput = new TextField();
        this.bourseInput.setPrefWidth(80f);
        bourseInput.setPromptText("Bourse");


        this.matriculeInput = new TextField();
        this.matriculeInput.setPrefWidth(80f);
        matriculeInput.setPromptText("Matricule");


        inputsButton = new InputsButtons(5, state, this);
        inputsButton.mount();
        this.getChildren().addAll(
          matriculeInput,
          namesInput,
          addressInput,
          bourseInput,
          inputsButton
        );
        this.setPadding(new Insets(15, 10,15, 10));
        ObservableList<Node> children = this.getChildren();
        children.forEach(node -> {
            HBox.setHgrow(node, Priority.ALWAYS);
        });



        namesInput.textProperty().bindBidirectional(state.nameStringProperty);
        matriculeInput.textProperty().bindBidirectional(state.matriculeStringProperty);
        addressInput.textProperty().bindBidirectional(state.adressStringPRoperty);
        bourseInput.textProperty().bindBidirectional(state.bourseStringProperty);

    }
}
