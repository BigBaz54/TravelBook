module eu.telecomnancy.travelBook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;

    opens eu.telecomnancy.travelBook to javafx.fxml;
    exports eu.telecomnancy.travelBook;
}