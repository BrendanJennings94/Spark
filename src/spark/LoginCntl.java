/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

/**
 *
 * @author brend
 */
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class LoginCntl {
    
    @FXML private Stage stage;
    @FXML private Label fail;
    @FXML private TextField userName;
    @FXML private PasswordField passField;
    private static LoginCntl theLoginCntl;
    
    
    public LoginCntl(){
        
    }
    
    @FXML void handleCreateButtonAction(ActionEvent event) throws IOException{
        Stage stage = (Stage) fail.getScene().getWindow();
        stage.hide();
        NewProfileCntl theNewProfileCntl = NewProfileCntl.getNewProfileCntl(stage); 
       
    }
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event){
        String attUN = userName.getText();
        String attPass = passField.getText();
        if(requestAuthenticate(attUN, attPass)){
            User theUser = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheUserList().getTheUserList().get(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheUserList().Authenticate(attUN, attPass));
            PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().setLoggedUser(theUser);
            PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
            Stage stage = (Stage) fail.getScene().getWindow();
            stage.hide();
            NavCntl theNavCntl = NavCntl.getNavCntl(stage);
        }
        else{
            userName.setText("");
            passField.setText("");
            fail.setVisible(true);
        }
    }

    public boolean requestAuthenticate(String attemptUN, String attemptPass){
        boolean result = false;
        int possibleUser;
        possibleUser = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheUserList().Authenticate(attemptUN, attemptPass);
        if(possibleUser!=-1){
            result = true;
        }
        
        return result;
    }
    
}
