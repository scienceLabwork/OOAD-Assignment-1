module com.example.filesplitter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.rudrashah.filesplitter to javafx.fxml;
    exports com.rudrashah.filesplitter;
}