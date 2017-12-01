/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brend
 */
public class FXMLProfileUIController  {
    @FXML private Button backBtn;
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
    
    
    
    @FXML protected void handleBackButtonAction(){
        Stage theStage = (Stage) backBtn.getScene().getWindow();
            theStage.hide();
            NavCntl.getNavCntl(theStage).setUpNavScene();
    }
    
    
    
    
}
