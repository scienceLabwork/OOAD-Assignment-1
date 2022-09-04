module com.example.filesplitter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.filesplitter to javafx.fxml;
    exports com.example.filesplitter;
}