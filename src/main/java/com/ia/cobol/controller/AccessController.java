package com.ia.cobol.controller;

import javafx.fxml.FXML;
import lombok.Setter;

public class AccessController {

  @Setter
  StartController startController;

  @FXML
  private void onActionDashboard(){

    startController.sceneDashboard();
  }

}
