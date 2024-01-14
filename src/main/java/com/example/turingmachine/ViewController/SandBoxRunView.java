package com.example.turingmachine.ViewController;

import com.example.turingmachine.Library.MethodLibrary;
import com.example.turingmachine.Library.ParameterLibrary;
import com.example.turingmachine.SceneNavigator;
import com.example.turingmachine.TupelClasses.TupelReadCode;
import com.example.turingmachine.TupelClasses.TupelWriteCode;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UniversalRunView implements Initializable {
    @FXML
    TextField inputField;
    @FXML
    HBox tape;
    @FXML
    ImageView arrow;
    @FXML
    TextArea codeArea;
    @FXML
    Label finalState, result;
    @FXML
    Text step, state;
    @FXML
    ChoiceBox <String> typeOfTMBox,exampleBox;
    @FXML
    Slider speedSlider;

    String input="";
    String[] lines;
    String name="Untitled";
    String init="";
    String accept="";
    int currentCell=ParameterLibrary.initializedCell;
    int countForRead=0;
    int countForWrite=0;
    public static TextField tapeArray[]= new TextField[100];
    TupelReadCode readArray[] = new TupelReadCode[100];
    TupelWriteCode writeArray[] = new TupelWriteCode[100];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MethodLibrary.setUpTheBoard(typeOfTMBox);
        MethodLibrary.setUpTheMachine(tape,arrow,tapeArray);
        MethodLibrary.setUpExampleBox(exampleBox,this.getClass().getSimpleName());
        typeOfTMBox.setOnAction(this::getScene);
        exampleBox.setOnAction(this::getExample);

        MethodLibrary.resetSteps(step,state);

        codeArea.setText(ParameterLibrary.ruleSaveForUniversal);
        addCodes();
    }

    public void getScene(ActionEvent event){
        MethodLibrary.getScene(typeOfTMBox);
    }

    public void getExample(ActionEvent event){ MethodLibrary.getExample(exampleBox, codeArea);}

    private void moveTheTape(Node tape, String direction, String currentState, int currentCell){
        TranslateTransition translation = MethodLibrary.createTransition(tape,direction);
        translation.setDuration(Duration.millis(ParameterLibrary.baseSpeed-speedSlider.getValue()*9));
        int finalDistanceX = (int) translation.getToX();
        translation.setOnFinished((event -> {
            tape.setLayoutX(tape.getLayoutX()+ finalDistanceX);
            tape.setTranslateX(0);
            runTuringMachine(currentState,currentCell);
        }));
        translation.play();
    }

    public void loadInput(ActionEvent event) {
        MethodLibrary.resetTape(tapeArray,arrow,tape);
        currentCell=ParameterLibrary.initializedCell;
        input = inputField.getText();
        MethodLibrary.loadInput(input,tapeArray,currentCell);
    }

    public void playBtn(ActionEvent event) {
        if (input!=""){
            MethodLibrary.resetSteps(step,state);
            runTuringMachine(init, 30);
        }else{
            MethodLibrary.showAlert("Input required", Alert.AlertType.ERROR);
        }
    }

    private void runTuringMachine(String currentState, int currentCell){
        ParameterLibrary.stepCounter++;
        int i=-1;
        for (int j = 0; j < countForRead; j++) {
            if ((Objects.equals(readArray[j].state, currentState)) && (Objects.equals(readArray[j].read, tapeArray[currentCell].getText()))) {
                i = j;
            }
        }
        if (i==-1){
            MethodLibrary.showResult(false, finalState, result, tapeArray);
        }else{
            currentState=writeArray[i].state;
            tapeArray[currentCell].setText(writeArray[i].write);
            String direction = MethodLibrary.translateDirection(writeArray[i].move);
            currentCell=MethodLibrary.translateCurrentCell(writeArray[i].move,currentCell);

            MethodLibrary.showSteps(state,currentState,step,ParameterLibrary.stepCounter);

            moveTheTape(tape,direction,currentState,currentCell);
        }
        if (Objects.equals(currentState, accept)){
            MethodLibrary.showResult(true, finalState, result, tapeArray);
        };
    }

    private void addCodes() {
        lines = codeArea.getText().split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith("name:")){
                name=lines[i].substring(6);
            }
            if (lines[i].startsWith("init:")){
                init=lines[i].substring(6);
            }
            if (lines[i].startsWith("accept:")){
                accept=lines[i].substring(8);
            }
        }
        if (init==""||accept==""){
            MethodLibrary.showAlert("The rule requires initial state and accept state:", Alert.AlertType.ERROR);
        }else{
            countForRead=0;
            countForWrite=0;
            for (int i = 0; i < lines.length; i++) {
                if ((!lines[i].startsWith("name"))&&(!lines[i].startsWith("init:"))&&(!lines[i].startsWith("accept:"))&&(!lines[i].startsWith("//"))){
                    String parts[]=lines[i].split(",");
                    if (parts.length==2){
                        readArray[countForRead]=new TupelReadCode(null,null);
                        readArray[countForRead].state=parts[0];
                        readArray[countForRead].read=parts[1];
                        readArray[countForRead].read=MethodLibrary.translateBlank(readArray[countForRead].read);
                        countForRead++;
                    }else if (parts.length==3){
                        writeArray[countForWrite]=new TupelWriteCode(null,null,null);
                        writeArray[countForWrite].state=parts[0];
                        writeArray[countForWrite].write=parts[1];
                        writeArray[countForWrite].move=parts[2];
                        writeArray[countForWrite].write=MethodLibrary.translateBlank(writeArray[countForWrite].write);
                        countForWrite++;
                    }
                }
            }
        }
    }

    public void pauseBtn(ActionEvent event) {
        System.out.println(this.getClass().getSimpleName());

    }


    public void stopBtn(ActionEvent event) {

    }

    public void backBtn(ActionEvent event) {
        SceneNavigator.navigateTo(SceneNavigator.Location.UNIVERSAL);
    }
}
