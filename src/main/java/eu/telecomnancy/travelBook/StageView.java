package eu.telecomnancy.travelBook;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class StageView extends StageObserver {
    private Stage mainStage;
    private Scene globalScene;
    private ArrayList<Scene> pageScenes;
    private BookModel bookModel;
    private StageController stageController;

    public StageView(Stage mainStage, Scene globalScene, BookModel bookModel, StageModel stageModel, StageController stageController) throws IOException {
        this.mainStage = mainStage;
        this.globalScene = globalScene;
        this.bookModel = bookModel;
        this.stageModel = stageModel;
        this.stageController = stageController;
        pageScenes = new ArrayList<>();
        for (PageModel page : this.bookModel.getPages()) {
            createPage("pageScene.fxml", page);
            page.alertObservers();
        }
        this.mainStage.setScene(globalScene);
        this.stageModel.addObserver(this);
    }

    public void createPage(String fxml, PageModel page) throws IOException {
        PageController pc = new PageController(page);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        loader.setControllerFactory(iC -> new PageScene(page, pc, this.stageController));
        Parent p = loader.load();
        Scene pageScene = new Scene(p);
        pageScenes.add(pageScene);
        stageController.incrNbPages(1);
        bookModel.alertObservers();
    }

    public void react() {
        int s = stageModel.getActiveScene();
        if (s==-1) {
            mainStage.setScene(globalScene);
        } else {
            mainStage.setScene(pageScenes.get(s));
        }
    }
}
