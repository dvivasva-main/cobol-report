package com.ia.cobol.controller;

import com.ia.cobol.model.Job;
import com.ia.cobol.service.JobsService;
import com.ia.cobol.util.AlertLbl;
import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class CobolController implements Initializable {

    public AnchorPane mainAnchor;
    public TextField txtAbsolutePath;
    public JFXButton btnGenerate;
    public TableView tableResult;


    @Setter
    StartController startController;

    String filePath;
    //File  myFile;

    @FXML
    private void onActionLoadFile() {
        Stage stage = (Stage) mainAnchor.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Elija un archivo de texto plano");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(".txt (Text simple) ", "*.txt"),
                new FileChooser.ExtensionFilter(".csv (Comma-separated values)", "*.csv"));

        fileChooser.setTitle("cargar archivo plano");

        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
            txtAbsolutePath.setText("" + file.getName());
            filePath = file.getAbsolutePath();
            //myFile=file;
            System.out.println("path:" + filePath);

        }
    }

    public void activeBtnGenerate() {
        BooleanBinding rs = txtAbsolutePath.textProperty().isEmpty();
        btnGenerate.disableProperty().bind(rs);
    }

    @FXML
    private void onActionDashboard() {
        startController.sceneDashboard();
    }

    @FXML
    private void onActionGenerate() {
        txtAbsolutePath.clear();
        // logic generate
        JobsService service = new JobsService();
        //jobs.removeIf(String::isEmpty);
        //jobs.stream().filter(line -> false);
        newJobs= service.jobsXX(filePath);
        /*System.out.println("size "+jobs.size());
        int count=0;
        //jobs.removeIf(s -> s.length() == 0);
        for (String s:jobs){

            System.out.println("row "+ count++ + "|"+s);
        }*/
        AlertLbl.success(startController.lblAlert, "process.... ");
    }



    @FXML
    private void createReport() {

        FileChooser fileChooser = new FileChooser();
        File file;
        String filename = txtAbsolutePath.getText();
        fileChooser.setTitle(":) save report");
        fileChooser.setInitialFileName(filename);
        file = fileChooser.showSaveDialog(null);


        if (file == null) {
            AlertLbl.warning(startController.lblAlert, "Cancel Operation :(");

        } else {
            String ruta = file.getAbsolutePath();
            writeUnicodeJava11(ruta,newJobs);
            AlertLbl.success(startController.lblAlert, "Success create report :) ");
        }

    }
    List<String> newJobs;
    public static void writeUnicodeJava11(String fileName, List<String> lines) {

        try (FileWriter fw = new FileWriter(new File(fileName), StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(fw)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        activeBtnGenerate();
    }
}
