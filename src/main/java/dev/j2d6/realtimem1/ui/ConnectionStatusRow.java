package dev.j2d6.realtimem1.ui;

import dev.j2d6.realtimem1.data.AppViewModel;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class ConnectionStatusRow extends HBox {

    private ConnectionStatusComponent status;
    private ModifyOrDeleteButtonsRow DM ;
    public AppViewModel state;


    public ConnectionStatusRow(double v, AppViewModel state) {
        super(v);
        this.state = state;
    }

    public void mount() {
        status = new ConnectionStatusComponent(10);
        status.mount();
        DM = new ModifyOrDeleteButtonsRow(10, state);
        DM.mount();
        Region spacer = new Region();

        HBox.setHgrow(spacer, Priority.ALWAYS);
        this.setPadding(new Insets(15));
        this.getChildren().addAll(
          DM,
          spacer,
          status
        );

    }

}
