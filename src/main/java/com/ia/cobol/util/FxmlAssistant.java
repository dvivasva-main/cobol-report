package com.ia.cobol.util;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class FxmlAssistant {

    static public URL getUrl(String fileName){
        return Objects
                .requireNonNull(FxmlAssistant.class
                        .getResource(fileName));
    }

    static public FXMLLoader fxmlLoader(String fileName){
        FXMLLoader fXMLLoader = new FXMLLoader();
        try {
            fXMLLoader.load(FxmlAssistant.getUrl(fileName).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fXMLLoader;
    }
}
