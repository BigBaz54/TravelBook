module eu.telecomnancy.visualcards {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens eu.telecomnancy.travelBook to javafx.fxml;
    exports eu.telecomnancy.travelBook;
}