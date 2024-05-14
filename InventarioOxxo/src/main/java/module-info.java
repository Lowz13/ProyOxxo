module com.example.inventariooxxo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.inventariooxxo to javafx.fxml;
    exports com.example.inventariooxxo;
}