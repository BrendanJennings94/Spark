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
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author brend
 */
public class PersTestCntl {
    private Stage stage;
    private static PersTestCntl PersTestCntl;
    @FXML
    private Button nextScreen;
    
    private PersTestCntl(Stage theExistingStage){
        
        stage = theExistingStage;
        setUpPersScene();
        stage.show();
    }
    
    public static PersTestCntl getPersCntl(Stage theStage){
        if(PersTestCntl != null){
            return PersTestCntl;
        }
        else{
            PersTestCntl = new PersTestCntl(theStage);
            return PersTestCntl;
        }
    }
    
    
    public void setUpPersScene(){
        Parent root;
        Scene scene;
        
        try{
        //just a note to change back to the original navigation view
        root = FXMLLoader.load(getClass().getResource("FXMLPersonalityTest1.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        
    
    public void exit(){
        System.exit(0);
    }
            
          
}
