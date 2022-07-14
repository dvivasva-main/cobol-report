package com.ia.cobol.controller;

import com.ia.cobol.util.FxmlAssistant;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {


    public StackPane stackContainer;
    public Label lblAlert;

    AccessController accessController;
    public void sceneAccess() {
        FXMLLoader fXMLLoader = FxmlAssistant.fxmlLoader("/access.fxml");
        accessController = fXMLLoader.getController();
        accessController.setStartController(this);
        addContent(fXMLLoader);
    }
    DashboardController dashboardController;
    public void sceneDashboard(){
        FXMLLoader fXMLLoader = FxmlAssistant.fxmlLoader("/dashboard.fxml");
        dashboardController = fXMLLoader.getController();
        dashboardController.setStartController(this);
        addContent(fXMLLoader);
    }
    CobolController cobolController;
    public void sceneCobol(){
        FXMLLoader fXMLLoader = FxmlAssistant.fxmlLoader("/cobol.fxml");
        cobolController = fXMLLoader.getController();
        cobolController.setStartController(this);
        addContent(fXMLLoader);
    }

    private void addContent(FXMLLoader fxmlLoader){
        AnchorPane acPane = fxmlLoader.getRoot();
        stackContainer.getChildren().clear();
        stackContainer.getChildren().add(acPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblAlert.setText("");
        sceneAccess();
    }
}
