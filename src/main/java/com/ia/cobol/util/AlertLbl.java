package com.ia.cobol.util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class AlertLbl {

	public static void success(Label lbl, String sms) {
		lbl.setStyle("-fx-text-fill:#30e849;");
		lbl.setText(sms);
		timeColor(lbl);
	}

	public static void error(Label lbl, String sms) {
		lbl.setStyle("-fx-text-fill:red;");
		lbl.setText(sms);
		timeColor(lbl);
	}
	public static void warning(Label lbl, String sms) {
		lbl.setStyle("-fx-text-fill:#4a148c;");
		lbl.setText(sms);
		timeColor(lbl);
	}
	static void timeColor(Label lbl){
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), evt -> lbl.setVisible(true)),
				new KeyFrame(Duration.seconds(2), evt -> lbl.setVisible(false)));
		timeline.setCycleCount(2);
		timeline.play();
	}
}
