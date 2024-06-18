module dev.j2d6.realtimem1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;


    opens dev.j2d6.realtimem1 to javafx.fxml;
    opens dev.j2d6.realtimem1.data to javafx.base, jakarta.xml.bind;

    exports dev.j2d6.realtimem1;
}