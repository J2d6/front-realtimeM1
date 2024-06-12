package dev.j2d6.realtimem1.ui;

import dev.j2d6.realtimem1.data.AppViewModel;
import dev.j2d6.realtimem1.utilities.connections.ConnectionStatusChecker;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ConnectionStatusComponent extends HBox {
   // MILA BINDINGS
    private Text status;
    private Circle circle;
    AppViewModel viewModel;

    public ConnectionStatusComponent(double v, AppViewModel viewModel) {
        super(v);
        this.viewModel = viewModel;
    }

    public void mount() {
        ObjectBinding<Color> colorObjectBinding = new ObjectBinding<Color>() {
            {
                super.bind(viewModel.connectionStatusProperty);
            }
            @Override
            protected Color computeValue() {
                return viewModel.getConnexionStatus() ? Color.FORESTGREEN : Color.RED ;
            }
        };

        status = new Text("Connection status");
        circle = new Circle(8);

        circle.fillProperty().bind(colorObjectBinding);
        ConnectionStatusChecker checker = new ConnectionStatusChecker(this.viewModel);
        Thread connexionCheckerThread = new Thread(checker);
        connexionCheckerThread.start();

        this.getChildren().addAll(
                status,
                circle
        );
    }


}
