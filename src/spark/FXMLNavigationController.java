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
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brend
 */
public class FXMLNavigationController  {
    //FXML DECLATIONS
    @FXML private Button exitBtn;
    @FXML private Button profBtn;
    @FXML private Button jobBtn;
    @FXML private Button persTest;
    @FXML private Button returnToHome;
    @FXML private CheckBox c1;
    @FXML private CheckBox c2;
    @FXML private CheckBox c3;
    @FXML private CheckBox c4;
    @FXML private CheckBox c5;
    @FXML private CheckBox c6;
    @FXML private CheckBox c7;
    @FXML private CheckBox c8;
    @FXML private CheckBox c9;
    @FXML private CheckBox c10;
    @FXML private CheckBox c11;
    @FXML private CheckBox c12;
    @FXML private CheckBox c13;
    @FXML private CheckBox c14;
    @FXML private CheckBox c15;
    @FXML private CheckBox c16;
    @FXML private Slider s1;
    @FXML private Slider s2;
    @FXML private Slider s3;
    @FXML private Slider s4;
    
    //PERSONALITY TEST VARIABLES
    private double MOBILE = 0;
    private double NOCT = 0;
    private double GOAL = 0;
    private double DETAIL = 0;
    private double SOCIAL = 0;
    private double FLEX = 0;
    
    @FXML protected void handleProfButtonAction(ActionEvent event){
        Stage stage = (Stage) profBtn.getScene().getWindow();
        stage.hide();
        ProfileCntl.getProfileCntl(stage).setUpProfileScene();
    }
    
    @FXML protected void handleExitButtonAction(ActionEvent event){
        Stage theStage = (Stage) exitBtn.getScene().getWindow();
        NavCntl.getNavCntl(theStage).exit();
    }
    
    @FXML protected void handleJobButtonAction(ActionEvent event){
        Stage theStage =(Stage) jobBtn.getScene().getWindow();
        theStage.hide();
        JobCntl.getJobCntl(theStage).setUpJobListScene();
    }
    
    @FXML protected void handleSumbitButtonAction(ActionEvent event){
        //PERSONALITY TEST RESULTS 
        
        MOBILE -= s1.getValue();
        
        GOAL += s2.getValue();
        FLEX += s2.getValue();
        NOCT += s2.getValue();
        
        FLEX += s3.getValue();
        MOBILE += s3.getValue();
        
       // PersonalityResults User1 = new PersonalityResults(MOBILE, NOCT, GOAL, DETAIL, SOCIAL, FLEX);
        

        
        //RETURN TO
        Stage newStage = (Stage) returnToHome.getScene().getWindow();
        newStage.hide();
        NavCntl returnBack = NavCntl.getNavCntl(newStage);
        
    }
    
    @FXML protected void handlePersTestButtonAction(ActionEvent event){
        Stage newStage = (Stage) persTest.getScene().getWindow();
        newStage.hide();
        PersTestCntl newPersTest = PersTestCntl.getPersCntl(newStage);
        
    }
    
    @FXML protected void handleCheckGroup1(){
        if (c1.isSelected()){
            c2.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
            
            //PERS TEST DATA 
            MOBILE += 5;
            SOCIAL += 2;
            }
        else if (c2.isSelected()){
            c1.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
            
            //PERS TEST DATA
            MOBILE += 10;
            
            }
        else if (c3.isSelected()){
            c1.setSelected(false);
            c2.setSelected(false);
            c4.setSelected(false);
            
            //PERS TEST DATA
            MOBILE -= 2;
            DETAIL += 10;
            }
        else {
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            
            //PERS TEST DATA
            DETAIL += 15;
            }
    }
    
    @FXML protected void handleCheckGroup2(){
        if (c5.isSelected()){
            c6.setSelected(false);
            
            //PERS TEST DATA
            NOCT -= 10;
        }
        else if (c6.isSelected()){
            c5.setSelected(false);
            
            //PERS TEST DATA
            NOCT += 10;
        }
    }
    
    @FXML protected void handleCheckGroup3(){
        if (c7.isSelected()){
            c8.setSelected(false);
            c9.setSelected(false);
            c10.setSelected(false);
            
            //PERS TEST DATA
            SOCIAL += 5;
            }
        else if (c8.isSelected()){
            c7.setSelected(false);
            c9.setSelected(false);
            c10.setSelected(false);
            
            //PERS TEST DATA
            NOCT += 2;
            SOCIAL -= 2;
            }
        else if (c9.isSelected()){
            c7.setSelected(false);
            c8.setSelected(false);
            c10.setSelected(false);
            
            //PERS TEST DATA
            SOCIAL += 10;
            }
        else if (c10.isSelected()){
            c7.setSelected(false);
            c8.setSelected(false);
            c9.setSelected(false);
            
            //PERS TEST DATA 
            SOCIAL -= 5;
            NOCT += 4;
        }
    }
    
    @FXML protected void handleCheckGroup4(){
        if (c11.isSelected()){
            c12.setSelected(false);
            
            //PERS TEST DATA
            DETAIL += 15;
        }
        else if (c12.isSelected()){
            c11.setSelected(false);
            
            //PERS TEST DATA
            GOAL += 15;
        }
    }
    
    @FXML protected void handleCheckGroup5(){
        if (c13.isSelected()){
            c14.setSelected(false);
            c15.setSelected(false);
            c16.setSelected(false);
            
            FLEX += 2;
        }
        else if (c14.isSelected()){
            c13.setSelected(false);
            c15.setSelected(false);
            c16.setSelected(false);
            
            FLEX += 4;
            }
        else if (c15.isSelected()){
            c13.setSelected(false);
            c14.setSelected(false);
            c16.setSelected(false);
            
            FLEX += 6;
            }
        else {
            c13.setSelected(false);
            c14.setSelected(false);
            c15.setSelected(false);
            
            FLEX += 8;
            }
    }

    /**
     * @return the MOBILE
     */
    public double getMOBILE() {
        return MOBILE;
    }

    /**
     * @return the NOCT
     */
    public double getNOCT() {
        return NOCT;
    }

    /**
     * @return the GOAL
     */
    public double getGOAL() {
        return GOAL;
    }

    /**
     * @return the DETAIL
     */
    public double getDETAIL() {
        return DETAIL;
    }

    /**
     * @return the SOCIAL
     */
    public double getSOCIAL() {
        return SOCIAL;
    }

    /**
     * @return the FLEX
     */
    public double getFLEX() {
        return FLEX;
    }
} 

