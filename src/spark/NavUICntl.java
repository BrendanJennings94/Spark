/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author brend
 */
public class NavUICntl  {
    //FXML DECLATIONS
    @FXML private Button logoutBtn;
    @FXML private Button profBtn;
    @FXML private Button jobBtn;
    @FXML private Button careerBtn;
    @FXML private Button persTest;
    
    
    @FXML protected void handleProfButtonAction(ActionEvent event){
        Stage stage = (Stage) profBtn.getScene().getWindow();
        stage.hide();
        ProfileCntl.getProfileCntl(stage).setUpProfileScene();
        
    }
    
    @FXML protected void handleLogoutButtonAction(ActionEvent event) throws URISyntaxException, IOException{
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        NavCntl.getNavCntl(stage).Logout();
       
    }
    
    @FXML protected void handleJobButtonAction(ActionEvent event){
        Stage theStage =(Stage) jobBtn.getScene().getWindow();
        theStage.hide();
        JobCntl.getJobCntl(theStage).setUpJobListScene();
       
    }
    
    @FXML protected void handleCareerButtonAction(ActionEvent event){
        Stage theStage =(Stage) careerBtn.getScene().getWindow();
        theStage.hide();
        CareerCntl.getCareerCntl(theStage).setUpCareerListScene();
    }
    
    
    
    @FXML protected void handlePersTestButtonAction(ActionEvent event){
        Stage newStage = (Stage) persTest.getScene().getWindow();
        newStage.hide();
        PersTestCntl newPersTest = PersTestCntl.getPersCntl(newStage);
        
    }
    
    
} 

