package com.example.turingmachine.Library;

import com.example.turingmachine.SceneNavigator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.Objects;

public class MethodLibrary {

    public static void setUpTheBoard(Label result, Label finalState, ChoiceBox<String> typeOfTMBox){
        result.setText("");
        finalState.setText("");
        result.setStyle("-fx-border-color: black;");
        finalState.setStyle("-fx-border-color: black;");

        typeOfTMBox.getItems().addAll(ParameterLibrary.choiceOfType);
        typeOfTMBox.setValue("Choose Type of TM");
    }

    public static void setUpTheMachine(HBox tape, ImageView arrow, TextField[] tapeArray){
        tape.setPrefWidth(100*50);
        for (int i = 0; i < 100; i++) {
            tapeArray[i] = new TextField();
            tapeArray[i].setMaxSize(50,50);
            tapeArray[i].setAlignment(Pos.CENTER);
            tapeArray[i].setFont(Font.font(20));
            tape.getChildren().add(tapeArray[i]);
        }
        tape.setLayoutX(arrow.getLayoutX()-12-50*30);
        tape.setLayoutY(arrow.getLayoutY()-50);
    }

    public static void setUpExampleBox(ChoiceBox<String> exampleBox, String className){
        switch (className){
            case "OneTapeView":
                exampleBox.getItems().addAll(ParameterLibrary.ExampleList.ONE_TAPE.getExampleList());
                break;
            case "TwoTapeView":
                exampleBox.getItems().addAll(ParameterLibrary.ExampleList.TWO_TAPE.getExampleList());
                break;
            case "ThreeTapeView":
                exampleBox.getItems().addAll(ParameterLibrary.ExampleList.THREE_TAPE.getExampleList());
                break;
            case "NonDeterministicView":
                exampleBox.getItems().addAll(ParameterLibrary.ExampleList.NON_DETERMINISTIC.getExampleList());
                break;
            default:
                break;
        }
    }

    public static void getScene(ChoiceBox<String> getSceneBox){
        String scene=getSceneBox.getValue();
        switch (scene){
            case "1 Tape":
                SceneNavigator.navigateTo(SceneNavigator.Location.ONE_TAPE);
                break;
            case "2 Tape":
                SceneNavigator.navigateTo(SceneNavigator.Location.TWO_TAPE);
                break;
            case "3 Tape":
                SceneNavigator.navigateTo(SceneNavigator.Location.THREE_TAPE);
                break;
            case "Non_Deterministic":
                SceneNavigator.navigateTo(SceneNavigator.Location.NON_DETERMINISTIC);
                break;
            case "MultiTracking3Tape":
                SceneNavigator.navigateTo(SceneNavigator.Location.MULTI_TRACKING_3_TAPE);
                break;
            default:
                break;
        }
    }

    public static void getExample(ChoiceBox<String> exampleBox, TextArea codeArea){
        String example= exampleBox.getValue();
        switch (example){
            case "Decimal To Binary":
                codeArea.setText(ExampleLibrary.Example.DECIMAL_TO_BI.getExample());
                break;
            case "Binary Palindrome":
                codeArea.setText(ExampleLibrary.Example.BINARY_PALINDROME.getExample());
                break;
            case "Binary Addition":
                codeArea.setText(ExampleLibrary.Example.BINARY_ADD.getExample());
                break;
            case "Even length a":
                codeArea.setText(ExampleLibrary.Example.EVEN_LENGTH_A.getExample());
                break;
            default:
                break;
        }
    }

    public static void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static TranslateTransition createTransition(Node tape, String direction){
        TranslateTransition translation = new TranslateTransition();
        translation.setDuration(Duration.seconds(1));
        translation.setNode(tape);
        translation.setToY(0);
        int distanceX=0;
        switch (direction){
            case "right":
                distanceX = -50;
                break;
            case "left":
                distanceX = 50;
                break;
            default:
                break;
        }
        translation.setToX(distanceX);
        return translation;
    }

    public static void moveTheTape(Node tape, String direction){
        TranslateTransition translation = createTransition(tape,direction);
        int finalDistanceX = (int) translation.getToX();
        translation.setOnFinished((event -> {
            tape.setLayoutX(tape.getLayoutX()+ finalDistanceX);
            tape.setTranslateX(0);
        }));
        translation.play();
    }

    public static void resetTape(TextField[] tapeArray, ImageView arrow, HBox tape){
        for (int i = 0; i < 100; i++) {
            tapeArray[i].setText("");
        }
        tape.setLayoutX(arrow.getLayoutX()-12-50*30);
    }


    public static void loadInput(String input,TextField[] tapeArray, int currentCell){
        for (int i = 0; i < input.length(); i++) {
            tapeArray[currentCell+i].setText(String.valueOf(input.charAt(i)));
        }
    }

    public static String translateDirection(String move){
        if (Objects.equals(move, ">")){
            return "right";
        }else if (Objects.equals(move, "<")){
            return "left";
        }else return "";
    }

    public static int translateCurrentCell(String move, int currentCell){
        if (Objects.equals(move, ">")){
            return currentCell+1;
        }else if (Objects.equals(move, "<")){
            return currentCell-1;
        }else return currentCell;
    }

    public static String translateBlank(String string){
        if (Objects.equals(string, "_")){
            return "";
        }else {
            return string;
        }
    }
}
