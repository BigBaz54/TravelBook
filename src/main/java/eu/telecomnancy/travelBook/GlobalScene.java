package eu.telecomnancy.travelBook;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

public class GlobalScene extends BookObserver {
    private StageController stageController;
    private ArrayList<StickerView> stickerViews;
    @FXML private Label titleLabel;
    @FXML private Label authorLabel;
    @FXML private Label startDateLabel;
    @FXML private Label endDateLabel;
    @FXML private Label membersLabel;

    public GlobalScene(BookModel bookModel, StageController stageController, BookController bookController) {
        this.bookModel = bookModel;
        this.stageController = stageController;
        this.bookController = bookController;
        this.bookModel.addObserver(this);
    }

    public void switchToPageScene() {
        stageController.switchToScene(0);
    }

    public void editTitle() {
        TextInputDialog textInput = new TextInputDialog(titleLabel.getText());
        textInput.setTitle("Titre");
        textInput.getDialogPane().setHeaderText("Entrer le nouveau titre : ");
        Optional<String> result = textInput.showAndWait();
        if (!result.isEmpty()) {
            TextField input = textInput.getEditor();
            if (input.getText() != "") {
                bookController.setTitle(input.getText());
            }
        }
    }

    public void editAuthor() {
        TextInputDialog textInput = new TextInputDialog(authorLabel.getText().substring(10));
        textInput.setTitle("Auteur");
        textInput.getDialogPane().setHeaderText("Entrer le nouvel auteur : ");
        Optional<String> result = textInput.showAndWait();
        if (!result.isEmpty()) {
            TextField input = textInput.getEditor();
            if (input.getText() != "") {
                bookController.setAuthor(input.getText());
            }
        }
    }

    public void editStartDate() {
        TextInputDialog textInput = new TextInputDialog(startDateLabel.getText().substring(3));
        textInput.setTitle("Date de début");
        textInput.getDialogPane().setHeaderText("Entrer la nouvelle date de début : ");
        Optional<String> result = textInput.showAndWait();
        if (!result.isEmpty()) {
            TextField input = textInput.getEditor();
            if (input.getText() != "") {
                bookController.setStartDate(input.getText());
            }
        }
    }

    public void editEndDate() {
        TextInputDialog textInput = new TextInputDialog(endDateLabel.getText().substring(3));
        textInput.setTitle("Date de fin");
        textInput.getDialogPane().setHeaderText("Entrer la nouvelle date de fin : ");
        Optional<String> result = textInput.showAndWait();
        if (!result.isEmpty()) {
            TextField input = textInput.getEditor();
            if (input.getText() != "") {
                bookController.setEndDate(input.getText());
            }
        }
    }

    public void editMembers() {
        TextInputDialog textInput = new TextInputDialog(membersLabel.getText().substring(15));
        textInput.setTitle("Participants");
        textInput.getDialogPane().setHeaderText("Entrer la nouvelle liste de participants : ");
        Optional<String> result = textInput.showAndWait();
        if (!result.isEmpty()) {
            TextField input = textInput.getEditor();
            if (input.getText() != "") {
                bookController.setMembers(input.getText());
            }
        }
    }

    public void react() {
        titleLabel.setText(bookModel.title);
        authorLabel.setText("Carnet de "+bookModel.author);
        startDateLabel.setText("Du "+bookModel.startDate);
        endDateLabel.setText("au "+bookModel.endDate);
        membersLabel.setText("Participants : "+bookModel.members);
    }
}
