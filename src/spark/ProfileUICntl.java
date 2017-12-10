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
public class ProfileUICntl implements Initializable  {
    @FXML private Button backBtn;
    @FXML private Button saveBtn;
    @FXML private TextField userName;
    @FXML private TextField passWord;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private RadioButton student;
    @FXML private RadioButton jobSeeker;
    @FXML private RadioButton employer;
    @FXML private TextField dateOfBirth;
    @FXML private TextField career;
    @FXML private TextArea bio;
     
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setText(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getUserName());
        passWord.setText(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getPassword());
        firstName.setText(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getFirstName());
        lastName.setText(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getLastName());
        dateOfBirth.setText(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getDateOfBirth());
        career.setText(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getCareer());
        bio.setText(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getBio());
        
        if(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getProfileType() == 1){
            student.selectedProperty().set(true);
        }
        else if(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getProfileType() == 2){
            jobSeeker.selectedProperty().set(true);
        }
        else if(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getProfileType() == 3){
            employer.selectedProperty().set(true);
        }
    }
    
    @FXML protected void handleBackButtonAction(){
        Stage theStage = (Stage) backBtn.getScene().getWindow();
        theStage.hide();
        NavCntl.getNavCntl(theStage).setUpNavScene();
    }

    @FXML protected void handleSaveButtonAction(){
        User updatedUser = new User(userName.getText(),passWord.getText(),firstName.getText(),lastName.getText(),dateOfBirth.getText(),career.getText(),bio.getText(),profTypeNumber());
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheUserList().updateUserInfo(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheUserList().matchUserIndex(updatedUser.getUserName()), updatedUser);
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().setLoggedUser(updatedUser);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
        
        Stage theStage = (Stage) backBtn.getScene().getWindow();
        theStage.hide();
        NavCntl.getNavCntl(theStage).setUpNavScene();
    }
    
    public int profTypeNumber(){
        int theNumber= 0;
        if(student.isSelected()){
            theNumber = 1;
        }
        else if(jobSeeker.isSelected()){
            theNumber = 2;
        }
        else if(employer.isSelected()){
            theNumber = 3;
        }
        return theNumber;
    }
}
