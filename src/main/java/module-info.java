module com.mycompany.crudobjectdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.crudobjectdb to javafx.fxml;
    exports com.mycompany.crudobjectdb;
}
