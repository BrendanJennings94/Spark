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
    
    @FXML private Label fail;
    @FXML private TextField userName;
    @FXML private PasswordField passField;
    @FXML private Stage theStage;
    
    
    public LoginCntl(){
        
    }
    
    @FXML void handleCreateButtonAction(ActionEvent event) throws IOException{
        Parent root;
        Stage stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("FXMLNewProfileUI.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(fail.getScene().getWindow());
        stage.showAndWait();
        
    }
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event){
        String attUN = userName.getText();
        String attPass = passField.getText();
        if(requestAuthenticate(attUN, attPass)){
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
       result = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getuserList().Authenticate(attemptUN, attemptPass);
        return result;
    }
    
    /**
     * @return the fail
     */
   
    
}
