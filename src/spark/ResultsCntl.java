/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bryson Wilks
 */

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
public class ResultsCntl {

    @FXML private Stage stage;
    private static ResultsCntl theResultsUICntl;
    private boolean PersonalityTestFlag;
    private static User theLoggedUser; 
    
    
    private ResultsCntl(Stage theExistingStage){
        PersonalityTestFlag = false;
        stage = theExistingStage;
        setUpResultsScene();
        stage.show();
        
    }
    
    public static ResultsCntl getResultsCntl(Stage theStage){
        if(theResultsUICntl != null){
            return theResultsUICntl;
        }
        else{
            theResultsUICntl = new ResultsCntl(theStage);
            return theResultsUICntl;
        }
    }
    
    @FXML public void setUpResultsScene(){
        Parent root;
        Scene scene;
        
        if (PersonalityTestFlag == false){
        try{
        //Custom navigation view
        root = FXMLLoader.load(getClass().getResource("FXMLJobRecUI.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }}
        else{
            try{
        //Changing back to the original navigation view
        root = FXMLLoader.load(getClass().getResource("FXMLJobRecUI.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }}
    }
}
