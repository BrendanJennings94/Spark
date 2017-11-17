/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author brend
 */
public class FXMLNewProfileController {
    @FXML private Button exitBtn;
    @FXML private Button saveBtn;
    @FXML private TextField userName;
    @FXML private TextField password;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private RadioButton student;
    @FXML private RadioButton jobSeeker;
    @FXML private RadioButton employer;
    @FXML private TextField dateOfBirth;
    @FXML private TextField career;
    @FXML private TextArea bio;
    @FXML private ToggleGroup group;
    @FXML Stage stage; 
    
    @FXML protected void handleExitButtonAction(ActionEvent event) throws Exception{
      Stage theStage = (Stage) exitBtn.getScene().getWindow();
      NewProfileCntl.getNewProfileCntl(theStage).exit();
       
    
    }
    
    @FXML protected void handleSaveButtonAction(ActionEvent event){
        String UN = userName.getText();
        String PW = password.getText();
        String FN = firstName.getText();
        String LN = lastName.getText();
        String DOB = dateOfBirth.getText();
        String car = career.getText();
        String biog = bio.getText();
        int type = 1;
        
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().addUser(UN, PW, FN, LN, DOB, car, biog, type);
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().printUser(3);
           
        
    }
}
