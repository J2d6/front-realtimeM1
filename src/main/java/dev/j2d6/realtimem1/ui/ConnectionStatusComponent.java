package dev.j2d6.realtimem1.ui;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class ConnectionStatusComponent extends HBox {
   // MILA BINDINGS
    private Text status;
    private Circle circle;

    public ConnectionStatusComponent(double v) {
        super(v);
    }

    public void mount() {

        status = new Text("Connection status");
        circle = new Circle(8);

        circle.setFill(Color.GREEN);


        this.getChildren().addAll(
                status,
                circle
        );
    }
}
