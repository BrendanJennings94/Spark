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
import javafx.fxml.LoadException;

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
    @FXML private Button returnToHome;
    @FXML private Button testJob;
    
    
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
    private double COMP = 0;
    ArrayList<Double> persTestValues = new ArrayList<Double>();
    CompatibiltyTest checkPersScores = new CompatibiltyTest();
    
      
    
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
    
    @FXML protected void handleTestJobButton(ActionEvent event) throws LoadException{
        Stage theStage =(Stage) testJob.getScene().getWindow();
        theStage.hide();
        ResultsCntl.getResultsCntl(theStage).setUpResultsScene();
    }
    
    @FXML protected void handleCareerButtonAction(ActionEvent event){
        Stage theStage =(Stage) careerBtn.getScene().getWindow();
        theStage.hide();
        CareerCntl.getCareerCntl(theStage).setUpCareerListScene();
    }
    
    @FXML protected void handleSumbitButtonAction(ActionEvent event){
        //PERSONALITY TEST RESULTS 
        
        MOBILE -= s1.getValue();
        
        GOAL += s2.getValue();
        FLEX += s2.getValue();
        NOCT += s2.getValue();
        
        FLEX += s3.getValue();
        MOBILE += s3.getValue();
        
        COMP += s4.getValue();        
        COMP *= 3;
        
        
       //persTestValues.add(MOBILE, NOCT, GOAL, DETAIL, SOCIAL, FLEX, COMP);
        persTestValues.add(MOBILE);
        persTestValues.add(NOCT);
        persTestValues.add(GOAL);
        persTestValues.add(DETAIL);
        persTestValues.add(SOCIAL);
        persTestValues.add(FLEX);
       
        persTestValues.add(COMP);
        
       
        //Updates the current logged users personality test scores
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().setPersTestValues(persTestValues);
        
        //Display Personality Test Values 
        System.out.println(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getPersTestValues());
        System.out.print("Mobile ");
        System.out.print("Noct ");
        System.out.print("Goal ");
        System.out.print("Detail ");
        System.out.print("Social ");
        System.out.println("Flex ");
        
        //Test Personality Scores
        checkPersScores.testPersValues(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser());
        System.out.println(checkPersScores.getRecommendedJob1());
        System.out.println(checkPersScores.getRecommendedJob2());
        
        //Setting the persTestFlag true so JobSuitability is able to be selected
        
        //testJob.setDisable(false); 
        //Can't set the button true 
        
        //RETURN TO
        Stage theStage = (Stage) returnToHome.getScene().getWindow();
        theStage.hide();
        NavCntl.getNavCntl(theStage).setUpNavScene();
        
    }
    
    @FXML protected void handlePersTestButtonAction(ActionEvent event){
        Stage newStage = (Stage) persTest.getScene().getWindow();
        newStage.hide();
        PersTestCntl newPersTest = PersTestCntl.getPersCntl(newStage);
        
    }
    
    @FXML protected void handleCheckGroup1(){
        if (c1.isSelected()){ //Jogging
            c2.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
            
            //PERS TEST DATA 
            MOBILE += 10;
            SOCIAL += 2;
            }
        else if (c2.isSelected()){ //Kayaking
            c1.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
            
            //PERS TEST DATA
            MOBILE += 20;
            
            }
        else if (c3.isSelected()){ //Readhing
            c1.setSelected(false);
            c2.setSelected(false);
            c4.setSelected(false);
            
            //PERS TEST DATA
            MOBILE -= 2;
            DETAIL += 10;
            }
        else { // Listening to music 
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            
            //PERS TEST DATA
            DETAIL += 5;
            }
    }
    
    @FXML protected void handleCheckGroup2(){
        if (c5.isSelected()){ // The Morning 
            c6.setSelected(false);
            
            //PERS TEST DATA
            NOCT -= 10;
            SOCIAL += 5;
        }
        else if (c6.isSelected()){ // The Night
            c5.setSelected(false);
            
            //PERS TEST DATA
            NOCT += 10;
            
        }
    }
    
    @FXML protected void handleCheckGroup3(){
        if (c7.isSelected()){ // The Park
            c8.setSelected(false);
            c9.setSelected(false);
            c10.setSelected(false);
            
            //PERS TEST DATA
            SOCIAL += 5;
            }
        else if (c8.isSelected()){ // A Quiet Cafe
            c7.setSelected(false);
            c9.setSelected(false);
            c10.setSelected(false);
            
            //PERS TEST DATA
            NOCT += 2;
            SOCIAL -= 2;
            }
        else if (c9.isSelected()){// The Beach
            c7.setSelected(false);
            c8.setSelected(false);
            c10.setSelected(false);
            
            //PERS TEST DATA
            SOCIAL += 10;
            }
        else if (c10.isSelected()){ // My room
            c7.setSelected(false);
            c8.setSelected(false);
            c9.setSelected(false);
            
            //PERS TEST DATA 
            SOCIAL -= 5;
            NOCT += 4;
        }
    }
    
    @FXML protected void handleCheckGroup4(){
        if (c11.isSelected()){ // Understanding how it works 
            c12.setSelected(false);
            
            //PERS TEST DATA
            DETAIL += 25;
            GOAL += 5;
        }
        else if (c12.isSelected()){ // Getting the problem correct
            c11.setSelected(false);
            
            //PERS TEST DATA
            GOAL += 20;
            
        }
    }
    
    @FXML protected void handleCheckGroup5(){
        if (c13.isSelected()){ //Not Very
            c14.setSelected(false);
            c15.setSelected(false);
            c16.setSelected(false);
            
            FLEX += 2;
        }
        else if (c14.isSelected()){ // A little
            c13.setSelected(false);
            c15.setSelected(false);
            c16.setSelected(false);
            
            FLEX += 4;
            }
        else if (c15.isSelected()){ // Slighty 
            c13.setSelected(false);
            c14.setSelected(false);
            c16.setSelected(false);
            
            FLEX += 6;
            }
        else { // Greatly 
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

