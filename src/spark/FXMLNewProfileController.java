/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author brend
 */
public class FXMLNewProfileController {
    @FXML private Button exitBtn;
    @FXML private TextField userName;
    @FXML private TextField password;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private RadioButton student;
    @FXML private RadioButton jobSeeker;
    @FXML private RadioButton employer;
    @FXML private TextField dateOfBirth;
    @FXML private TextField career;
    @FXML private TextField bio;
    @FXML private ToggleGroup group;
    
    @FXML protected void handleExitButtonAction(ActionEvent event){
        Stage theStage = (Stage) exitBtn.getScene().getWindow();
        theStage.close();
    }
    
    @FXML protected void handleSaveButtonAction(ActionEvent event){
        
    }
}
