package com.example.turingmachine;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneNavigator {
    private SceneNavigator() {
    }

    public static void navigateTo(Location location) {
        String fullResourceString = location.getFileName() + ".fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(SceneNavigator.class.getResource(fullResourceString));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1200, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HelloApplication.getPrimaryStage().setTitle("Hello!");
        HelloApplication.getPrimaryStage().setScene(scene);
    }


    public enum Location {
        ONE_TAPE("oneTapeView"),
        TWO_TAPE("twoTapeView"),
        THREE_TAPE("threeTapeView"),
        MULTI_TRACKING_3_TAPE("multiTracking3TapeView"),
        NON_DETERMINISTIC("Non_DeterministicView");

        private final String fileName;

        Location(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }

}
