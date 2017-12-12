/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

/**
 *
 * @author Bryson Wilks
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLJobRecUIController implements Initializable{
    
    @FXML private TableView<String> recommendedJobs = new TableView<String>();
    @FXML private ObservableList<String> listOfJobs; 
    CompatibiltyTest checkScores = new CompatibiltyTest();
    @FXML private Button backBtn;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
    User testUser = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser();
    checkScores.testPersValues(testUser);
    
    listOfJobs.add(checkScores.getRecommendedJob1());
    listOfJobs.add(checkScores.getRecommendedJob2());
    
    recommendedJobs.setItems(listOfJobs);
        
   }
    
   public void handleBackButtonAction(){
        Stage theStage = (Stage) backBtn.getScene().getWindow();
        theStage.hide();
        JobCntl.getJobCntl(theStage).getNavCntl(theStage);
    } 
}