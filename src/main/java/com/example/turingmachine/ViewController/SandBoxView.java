package com.example.turingmachine.ViewController;

import com.example.turingmachine.Library.MethodLibrary;
import com.example.turingmachine.Library.ParameterLibrary;
import com.example.turingmachine.SceneNavigator;
import com.example.turingmachine.TupelClasses.TupelReadCode;
import com.example.turingmachine.TupelClasses.TupelWriteCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UniversalView {
    @FXML
    TextField nOStatesTextField,accStateTextField,rejStateTextField,alphabetTextField,readTextField,writeTextField,newStateTextField;
    @FXML
    Button nOStatesBtn,accStateBtn,rejStateBtn,alphabetBtn,alphabetAddBtn,rightBtn,stayBtn,leftBtn,nextStateOKBtn,nextStateNoBtn,startBtn;
    @FXML
    Label nOStateLabel,accStateLabel,rejStateLabel,alphabetLabel,rulesLabel;
    @FXML
    Text nOStatesText,accStateText,rejStateText,alphabetText,forStateText,readText,writeText,directionText,nextStateText,startText,rulesText,newStateText;

    int nOStates,stateCounter,readArrayCounter,inputCurrentState;
    String accState, rejState, alphabetBox;
    String[] stateArray;
    TupelReadCode readArray[] = new TupelReadCode[100];
    TupelWriteCode writeArray[] = new TupelWriteCode[100];


    public void initialize() {
        hideNonUseNode();
        resetParameter();
    }

    private void resetParameter(){
        stateCounter=0;
        readArrayCounter=0;
        alphabetBox="";
        inputCurrentState=0;
        forStateText.setText("For state 0 (initial state):");
    }

    private void showNewRuleOnTheRulesLabel(){
        int counter =readArrayCounter;
        String newRule = String.valueOf(inputCurrentState)+","+ readArray[counter].read+"\n";
        newRule += writeArray[counter].state+","+writeArray[counter].write+","+writeArray[counter].move+"\n";
        rulesLabel.setText(rulesLabel.getText()+newRule);
    }

    private void hideNonUseNode(){
        nOStatesText.setVisible(true);
        nOStatesTextField.setVisible(true);
        nOStateLabel.setVisible(true);
        nOStatesBtn.setVisible(true);

        accStateTextField.setVisible(false);
        rejStateTextField.setVisible(false);
        alphabetTextField.setVisible(false);
        readTextField.setVisible(false);
        writeTextField.setVisible(false);
        accStateBtn.setVisible(false);
        rejStateBtn.setVisible(false);
        alphabetAddBtn.setVisible(false);
        alphabetBtn.setVisible(false);
        rightBtn.setVisible(false);
        leftBtn.setVisible(false);
        stayBtn.setVisible(false);
        nextStateNoBtn.setVisible(false);
        nextStateOKBtn.setVisible(false);
        startBtn.setVisible(false);
        accStateLabel.setVisible(false);
        rejStateLabel.setVisible(false);
        alphabetLabel.setVisible(false);
        rulesLabel.setVisible(false);
        accStateText.setVisible(false);
        rejStateText.setVisible(false);
        alphabetText.setVisible(false);
        forStateText.setVisible(false);
        readText.setVisible(false);
        writeText.setVisible(false);
        directionText.setVisible(false);
        nextStateText.setVisible(false);
        startText.setVisible(false);
        rulesText.setVisible(false);
        newStateText.setVisible(false);
        newStateTextField.setVisible(false);
    }

    public void nOStatesClicked(ActionEvent event) {
        nOStates = Integer.parseInt(nOStatesTextField.getText());
        nOStateLabel.setText(String.valueOf(nOStates));
        nOStatesTextField.setVisible(false);
        nOStatesBtn.setVisible(false);

        accStateText.setVisible(true);
        accStateLabel.setVisible(true);
        accStateBtn.setVisible(true);
        accStateTextField.setVisible(true);
    }

    public void accStateClicked(ActionEvent event) {
        accState = accStateTextField.getText();
        accStateLabel.setText(accState);
        accStateTextField.setVisible(false);
        accStateBtn.setVisible(false);

        rejStateText.setVisible(true);
        rejStateLabel.setVisible(true);
        rejStateBtn.setVisible(true);
        rejStateTextField.setVisible(true);
    }

    public void rejStateClicked(ActionEvent event) {
        rejState = rejStateTextField.getText();
        rejStateLabel.setText(accState);
        rejStateTextField.setVisible(false);
        rejStateBtn.setVisible(false);

        alphabetText.setVisible(true);
        alphabetLabel.setVisible(true);
        alphabetBtn.setVisible(true);
        alphabetAddBtn.setVisible(true);
        alphabetTextField.setVisible(true);
    }

    public void alphabetAddClicked(ActionEvent event) {
        String alphabetInput = alphabetTextField.getText();
        if (alphabetInput != ""){
            alphabetBox += alphabetInput;
            alphabetLabel.setText(alphabetLabel.getText()+alphabetInput+" ");
        }
    }

    public void alphabetClicked(ActionEvent event) {
        alphabetBtn.setVisible(false);
        alphabetAddBtn.setVisible(false);
        alphabetTextField.setVisible(false);

        forStateText.setVisible(true);
        readText.setVisible(true);
        readTextField.setVisible(true);
        writeText.setVisible(true);
        writeTextField.setVisible(true);
        directionText.setVisible(true);
        rightBtn.setVisible(true);
        leftBtn.setVisible(true);
        stayBtn.setVisible(true);
        nextStateText.setVisible(true);
        nextStateOKBtn.setVisible(true);
        nextStateNoBtn.setVisible(true);
        newStateText.setVisible(true);
        newStateTextField.setVisible(true);
        rulesLabel.setVisible(true);
        rulesText.setVisible(true);
    }


    public void leftCLicked(ActionEvent event) {
        String read = readTextField.getText();
        String write = writeTextField.getText();

        if ((!Objects.equals(read, ""))&(!Objects.equals(write, ""))){
            readArray[readArrayCounter]=new TupelReadCode(null,null);
            readArray[readArrayCounter].state=String.valueOf(inputCurrentState);
            readArray[readArrayCounter].read=read;

            writeArray[readArrayCounter]=new TupelWriteCode(null,null,null);
            writeArray[readArrayCounter].state=newStateTextField.getText();
            writeArray[readArrayCounter].write=write;
            writeArray[readArrayCounter].move="<";

            showNewRuleOnTheRulesLabel();
            readArrayCounter++;
        }
    }

    public void stayClicked(ActionEvent event) {
        String read = readTextField.getText();
        String write = writeTextField.getText();

        if ((!Objects.equals(read, ""))&(!Objects.equals(write, ""))){
            readArray[readArrayCounter]=new TupelReadCode(null,null);
            readArray[readArrayCounter].state=String.valueOf(inputCurrentState);
            readArray[readArrayCounter].read=read;

            writeArray[readArrayCounter]=new TupelWriteCode(null,null,null);
            writeArray[readArrayCounter].state=newStateTextField.getText();
            writeArray[readArrayCounter].write=write;
            writeArray[readArrayCounter].move="-";

            showNewRuleOnTheRulesLabel();
            readArrayCounter++;
        }
    }

    public void rightClicked(ActionEvent event) {
        String read = readTextField.getText();
        String write = writeTextField.getText();

        if ((!Objects.equals(read, ""))&(!Objects.equals(write, ""))){
            readArray[readArrayCounter]=new TupelReadCode(null,null);
            readArray[readArrayCounter].state=String.valueOf(inputCurrentState);
            readArray[readArrayCounter].read=read;

            writeArray[readArrayCounter]=new TupelWriteCode(null,null,null);
            writeArray[readArrayCounter].state=newStateTextField.getText();
            writeArray[readArrayCounter].write=write;
            writeArray[readArrayCounter].move=">";

            showNewRuleOnTheRulesLabel();
            readArrayCounter++;
        }
    }

    public void saveRulesForUnviersalRun(){
        ParameterLibrary.ruleSaveForUniversal="";
        ParameterLibrary.ruleSaveForUniversal += "init: "+0+"\n";
        ParameterLibrary.ruleSaveForUniversal += "accept: "+accState+"\n";
        ParameterLibrary.ruleSaveForUniversal += rulesLabel.getText();
    }

    public void nextStateOKClicked(ActionEvent event) {
        inputCurrentState++;
        forStateText.setText("For state "+inputCurrentState+":");
    }

    public void nextStateNoClicked(ActionEvent event) {
        startText.setVisible(true);
        startBtn.setVisible(true);
    }

    public void startClicked(ActionEvent event) {
        saveRulesForUnviersalRun();
        SceneNavigator.navigateTo(SceneNavigator.Location.UNIVERSAL_RUN);
    }
}
