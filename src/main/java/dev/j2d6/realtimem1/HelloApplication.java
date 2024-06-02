package dev.j2d6.realtimem1;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.data.Etudiant;
import dev.j2d6.realtimem1.ui.AppBar;
import dev.j2d6.realtimem1.ui.ConnectionStatusRow;
import dev.j2d6.realtimem1.ui.InputRow;
import dev.j2d6.realtimem1.ui.TableFactory;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class  HelloApplication extends Application {
    public AppViewModel state;
    @Override
    public void start(Stage stage) throws IOException {
       buildUI(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    private void buildUI (Stage stage) {

        //STATE
        this.state = new AppViewModel();

        //APPBAR
        AppBar appBar = new AppBar("JNB");
        appBar.mount();
        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);
        //InputsRow
        InputRow inputsRow = new InputRow(10, state);
        inputsRow.mount();

        // APP STATE
        AppViewModel viewModel = new AppViewModel();




        TableFactory etudiantListTable = new TableFactory(state);
        System.out.println(this.state);
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
}