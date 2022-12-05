module com.example.tpdevopssharedlibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.groovy;


    opens com.example.tpdevopssharedlibrary to javafx.fxml;
    exports com.example.tpdevopssharedlibrary;
}