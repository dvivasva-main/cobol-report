package com.ia.cobol;

import com.ia.cobol.util.FxmlAssistant;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try{

            Parent parent =FXMLLoader.load(FxmlAssistant.getUrl("/start.fxml"));
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(FxmlAssistant.getUrl("/css/start.css").toExternalForm());
            stage.setTitle("App");
            stage.resizableProperty().setValue(false);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
