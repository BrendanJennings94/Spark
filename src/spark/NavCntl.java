/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

/**
 *
 * @author brend
 */
public class NavCntl {
    @FXML private Stage stage;
    private static NavCntl theNavCntl;
    private boolean PersonalityTestFlag;
    
    private NavCntl(Stage theExistingStage){
        PersonalityTestFlag = false;
        stage = theExistingStage;
        setUpNavScene();
        stage.show();
    }
    
    public static NavCntl getNavCntl(Stage theStage){
        if(theNavCntl != null){
            return theNavCntl;
        }
        else{
            theNavCntl = new NavCntl(theStage);
            return theNavCntl;
        }
    }
    
    @FXML public void setUpNavScene(){
        Parent root;
        Scene scene;
        
        if (PersonalityTestFlag == false){
        try{
        //Custom navigation view
        root = FXMLLoader.load(getClass().getResource("FXMLNavigation.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }}
        else{
            try{
        //Changing back to the original navigation view
        root = FXMLLoader.load(getClass().getResource("FXMLNavigation.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }}
    }
    
    public void exit(){
        System.exit(0);
    }
    
    public void getJobCntl(Stage theStage){
        JobCntl.getJobCntl(theStage);
    }
}
