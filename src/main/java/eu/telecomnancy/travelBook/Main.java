package eu.telecomnancy.travelBook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageModel sm = new StageModel();
        BookModel bm = new Gson().fromJson(new String(Files.readAllBytes(Paths.get("src/main/resources/eu/telecomnancy/travelBook/book.json"))), BookModel.class);
        BookController bc = new BookController(bm);
        StageController sc = new StageController(sm);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("globalScene.fxml"));
        loader.setControllerFactory(iC -> new GlobalScene(bm, sc, bc));
        Parent global = loader.load();
        Scene globalScene = new Scene(global);

        StageView stageView = new StageView(primaryStage, globalScene, bm, sm, sc);

        primaryStage.setTitle("Travel Book");
        primaryStage.setScene(globalScene);
        primaryStage.show();
    }
}
