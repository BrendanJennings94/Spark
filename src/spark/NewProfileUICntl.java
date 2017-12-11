/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;


import java.io.IOException;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class NewProfileUICntl {
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
    @FXML Stage stage; 
    
    
    
    @FXML protected void handleSaveButtonAction(ActionEvent event) throws URISyntaxException, IOException{
        String UN = userName.getText();
        String PW = password.getText();
        String FN = firstName.getText();
        String LN = lastName.getText();
        String DOB = dateOfBirth.getText();
        String car = career.getText();
        String biog = bio.getText();
        int type=1;
        
        if(student.isSelected()){
            type=1;
        }
        else if(jobSeeker.isSelected()){
            type=2;
        }
        else if(employer.isSelected()){
            type = 3;
        }
        
        
        
        User newUser = new User(UN,PW,FN,LN,DOB,car,biog,type, null);
       
        Stage theStage = (Stage) saveBtn.getScene().getWindow();
        NewProfileCntl.getNewProfileCntl(theStage).addUser(newUser);
        NewProfileCntl.getNewProfileCntl(theStage).restartApplication();
       
    }
    
    @FXML protected void handleBackButtonAction(ActionEvent event) throws IOException, URISyntaxException{
        Stage theStage = (Stage) backBtn.getScene().getWindow();
        theStage.hide();
        
        NewProfileCntl.getNewProfileCntl(theStage).restartApplication();
        
        
    }
    
}
