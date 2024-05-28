package dev.j2d6.realtimem1.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;



public class AppBar extends HBox {
    private String title ;
    private Region spacer = new Region();
    public AppBar(String title) {
        super();
        this.title = title;
    }

    public AppBar(Node... nodes) {
        super(nodes);
    }

    public AppBar(double v, Node... nodes) {
        super(v, nodes);
    }

    public void mount () {
        this.setPadding(new Insets(20f));
        Text title = new Text(this.title);

        TextField serachBar = new TextField();
        serachBar.setPromptText("Rechercher");

        HBox.setHgrow(spacer, Priority.ALWAYS);

        this.getChildren().addAll(serachBar, spacer, title);



    }
}
