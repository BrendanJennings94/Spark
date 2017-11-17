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
 * @author brend
 */
public class ProfileCntl {
     @FXML private Stage stage;
    private static ProfileCntl theProfileCntl;
    
    private ProfileCntl(Stage theExistingStage){
        stage = theExistingStage;
        setUpProfileScene();
        stage.show();
    }
    
    public static ProfileCntl getProfileCntl(Stage theStage){
        if(theProfileCntl != null){
            return theProfileCntl;
        }
        else{
            theProfileCntl = new ProfileCntl(theStage);
            return theProfileCntl;
        }
    }
    
    @FXML public void setUpProfileScene(){
        Parent root;
        Scene scene;
        
        try{
        root = FXMLLoader.load(getClass().getResource("FXMLProfileUI.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
