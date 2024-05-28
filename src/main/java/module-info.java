module dev.j2d6.realtimem1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.j2d6.realtimem1 to javafx.fxml;
    opens dev.j2d6.realtimem1.data to javafx.base;

    exports dev.j2d6.realtimem1;
}