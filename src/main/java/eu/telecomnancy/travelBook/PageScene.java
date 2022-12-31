package eu.telecomnancy.travelBook;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class PageScene extends PageObserver {
    private StageController stageController;
    @FXML private Label textLabel;
    @FXML private Label titleLabel;
    @FXML private ImageView image;

    public PageScene(PageModel pageModel, PageController pageController, StageController stageController) {
        this.pageModel = pageModel;
        this.pageController = pageController;
        this.stageController = stageController;
        this.pageModel.addObserver(this);
    }

    public void switchToGlobalScene() {
        stageController.switchToScene(-1);
    }

    public void nextPage() {
        stageController.nextPage();
    }

    public void prevPage() {
        stageController.prevPage();
    }

    public void editTitle() {
        TextInputDialog textInput = new TextInputDialog(titleLabel.getText());
        textInput.setTitle("Titre");
        textInput.getDialogPane().setHeaderText("Entrer le nouveau titre : ");
        Optional<String> result = textInput.showAndWait();
        if (!result.isEmpty()) {
            TextField input = textInput.getEditor();
            if (input.getText() != "") {
                pageController.setTitle(input.getText());
            }
        }
    }

    public void editText() {
        TextInputDialog textInput = new TextInputDialog(textLabel.getText());
        textInput.setTitle("Texte");
        textInput.getDialogPane().setHeaderText("Entrer le nouveau texte : ");
        Optional<String> result = textInput.showAndWait();
        if (!result.isEmpty()) {
            TextField input = textInput.getEditor();
            if (input.getText() != "") {
                pageController.setText(input.getText());
            }
        }
    }

    public void editImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Image");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            pageController.setImage(file.toString());
        }
    }

    public void react() {
        this.textLabel.setText(pageModel.text);
        this.titleLabel.setText(pageModel.title);
        this.image.setImage(new Image(pageModel.path));
    }
}
