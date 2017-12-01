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


public class NewProfileCntl {
    
    @FXML private Stage stage;
    private static NewProfileCntl theNewProfileCntl;
    
    private NewProfileCntl(Stage theExistingStage){
        stage = theExistingStage;
        setUpNewProfileScene();
        stage.show();
    }
    
    public static NewProfileCntl getNewProfileCntl(Stage theStage){
        if(theNewProfileCntl != null){
            return theNewProfileCntl;
        }
        else{
            theNewProfileCntl = new NewProfileCntl(theStage);
            return theNewProfileCntl;
        }
    }
    @FXML public void setUpNewProfileScene(){
        Parent root;
        Scene scene;
        
        try{
        root = FXMLLoader.load(getClass().getResource("FXMLNewProfileUI.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addUser(User newUser){
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheUserList().getTheUserList().add(newUser);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
    }
    
    public void exit(){
        System.exit(0);
    }
   
}

    