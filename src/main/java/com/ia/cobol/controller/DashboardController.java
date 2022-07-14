package com.ia.cobol.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import lombok.Setter;

public class DashboardController {

    public StackPane stackMenuContainer;

    @Setter
    StartController startController;

    @FXML
    private void  onActionCobol(){
        startController.sceneCobol();
    }
    @FXML
    private void onActionLogOut(){
        startController.sceneAccess();
    }
}
