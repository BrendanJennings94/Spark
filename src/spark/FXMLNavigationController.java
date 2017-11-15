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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brend
 */
public class FXMLNavigationController  {
    @FXML private Button exitBtn;
    
    @FXML protected void handleExitButtonAction(ActionEvent event){
        Stage theStage = (Stage) exitBtn.getScene().getWindow();
        NavCntl.getNavCntl(theStage).exit();
    }  
}
