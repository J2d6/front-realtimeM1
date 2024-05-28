package dev.j2d6.realtimem1;

import dev.j2d6.realtimem1.data.Etudiant;
import dev.j2d6.realtimem1.data.Product;
import dev.j2d6.realtimem1.ui.AppBar;
import dev.j2d6.realtimem1.ui.ConnectionStatusRow;
import dev.j2d6.realtimem1.ui.InputRow;
import dev.j2d6.realtimem1.ui.TableFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        //APPBAR
        AppBar appBar = new AppBar("JNB");
        appBar.mount();
        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);
        //InputsRow
        InputRow inputsRow = new InputRow(10);
        inputsRow.mount();



        //tableView - Etudiants
        ObservableList<Etudiant> etudiantsListe = FXCollections.observableArrayList(
          new Etudiant(
                  "2318",
                  "RAZAKAMANANTSOA Dimbiniaina Jordany",
                  "Villa HD Game Ampitankely",
                  211000
          ),
          new Etudiant(
                  "2299",
                  "ZAFINDRAZANAKA Marie Jeannette Rakotoniaina",
                  "Analamahintsy Antananarivo",
                  500000
          )     ,
          new Etudiant(
                  "2587",
                  "Miza Tommy",
                  "RDI - Fianarantsoa",
                  211000
          )      ,
                new Etudiant(
                        "7894",
                        "RASAMOELINA Bien Aimé Patrick",
                        "Tanambao Fianrantsoa",
                        211000
                )
        );
        TableFactory etudiantListTable = new TableFactory(etudiantsListe);
        HBox table = etudiantListTable.factor();

        //Footer
        ConnectionStatusRow footer = new ConnectionStatusRow(10);
        footer.mount();

        //layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(appBar,separator, inputsRow, table, footer );
        Scene mainScene = new Scene(layout, 800,550);
        stage.setTitle("JNB");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}