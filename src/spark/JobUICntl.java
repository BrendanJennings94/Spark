/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

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

/**
 *
 * @author brend
 */
public class JobUICntl implements Initializable{
    
   @FXML private TableView<Job> jobTable = new TableView<Job>();
   @FXML private TableColumn<Job, String> jobTitleColumn = new TableColumn("Job Title");
   @FXML private TableColumn<Job, String> companyColumn  = new TableColumn("company");;
   @FXML private TableColumn<Job, String> salaryColumn  = new TableColumn("Username");;
   @FXML private ObservableList<Job> listOfJobs; 
   @FXML private Button postJobBtn;
   @FXML private Button backBtn;
   @FXML private TextField jobTitleTxt;
   @FXML private TextField jobCompanyTxt;
   @FXML private TextField jobSalaryTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listOfJobs = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheJobList().getJobData();
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<Job,String>("jobTitle"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<Job,String>("company"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Job,String>("salary"));
        
        jobTable.setItems(listOfJobs);
        
        if(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getProfileType()!=3){
            postJobBtn.setDisable(true);
        }
        
    }
    
    public void handlePostJobButtonAction(){
        Job newJob = new Job(jobTitleTxt.getText(),jobCompanyTxt.getText(),jobSalaryTxt.getText());
        Stage theStage = (Stage) postJobBtn.getScene().getWindow();
        JobCntl.getJobCntl(theStage).addJob(newJob); 
    }
    
    public void handleBackButtonAction(){
        Stage theStage = (Stage) backBtn.getScene().getWindow();
        theStage.hide();
        JobCntl.getJobCntl(theStage).getNavCntl(theStage);
    }
    
}
