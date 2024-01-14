package com.example.turingmachine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage pStage;

    @Override
    public void start(Stage stage) throws IOException {
        setPrimaryStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oneTapeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        pStage.setTitle("Hello!");
        pStage.setScene(scene);


        pStage.show();
    }

    public static Stage getPrimaryStage(){
        return pStage;
    }

    public void setPrimaryStage(Stage stage){
        HelloApplication.pStage=stage;
    }

    public static void main(String[] args) {
        launch();
    }
}