package dev.j2d6.realtimem1.ui;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.data.Etudiant;
import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class TableFactory {
    private  ObservableList items;
    public AppViewModel state;


    public TableFactory (AppViewModel state) {
        this.state = state;
    }

    public HBox factor() {
        //layout
        HBox layout = new HBox();
        layout.setPadding(new Insets(10));

        TableColumn<Etudiant, String> nameColumn = new TableColumn<>("NOM et Prénom(s)");
        nameColumn.setMinWidth(300);
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("nom")
        );

        TableColumn<Etudiant, String> adressColumn = new TableColumn<>("Adresse");
        adressColumn.setMinWidth(300);
        adressColumn.setCellValueFactory(
                new PropertyValueFactory<>("adresse")
        );
        TableColumn<Etudiant, Integer> bourseColumn = new TableColumn<>("Bourse");
        bourseColumn.setMinWidth(100);
        bourseColumn.setCellValueFactory(
                new PropertyValueFactory<>("bourse")
        );
        TableColumn<Etudiant, String> matriculeColumn = new TableColumn<>("Matricule");
        matriculeColumn.setMinWidth(100);
        matriculeColumn.setCellValueFactory(
                new PropertyValueFactory<>("matricule")
        );

        TableView<Etudiant> studentsTable = new TableView<>();
        nameColumn.prefWidthProperty().bind(studentsTable.widthProperty().divide(2.6));
        adressColumn.prefWidthProperty().bind(studentsTable.widthProperty().divide(2.6));
        matriculeColumn.prefWidthProperty().bind(studentsTable.widthProperty().divide(8));
        bourseColumn.prefWidthProperty().bind(studentsTable.widthProperty().divide(8));
        studentsTable.getColumns().addAll(
                matriculeColumn,
                nameColumn,
                bourseColumn,
                adressColumn
        );

        studentsTable.setItems(items);

        layout.getChildren().addAll(
                studentsTable
        );
        HBox.setHgrow(studentsTable, Priority.ALWAYS);
        layout.setAlignment(Pos.CENTER);

        studentsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            state.selectedStudentProperty = newValue;
        });
//        state.selectedStudentProperty.bindBidirectional(
//                (Property<Etudiant>) studentsTable.getSelectionModel().selectedItemProperty()
//        );
        //data
        studentsTable.setItems(state.etudiantsList);
        return layout;
    }
}
