/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.net.URL;
import java.util.ResourceBundle;
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
public class CareerUICntl implements Initializable {
    
    @FXML private TableView<Career> careerTable = new TableView<Career>();
    @FXML private TableColumn<Career, String> careerColumn = new TableColumn("Career");
    @FXML private TableColumn<Career, String> descriptionColumn = new TableColumn("Description");
    @FXML private TableColumn<Career, String> salaryRangeColumn = new TableColumn("Salary Range");
    @FXML private ObservableList<Career> listOfCareers;
    @FXML private Button postBtn;
    @FXML private Button backBtn;
    @FXML private TextField careerTxt;
    @FXML private TextField descriptionTxt;
    @FXML private TextField salaryRangeTxt;
    @FXML private TableView<String> recommendedJobs = new TableView<String>();
    @FXML private ObservableList<String> listOfJobs; 
    CompatibiltyTest checkScores = new CompatibiltyTest();
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listOfCareers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheCareerList().getCareerData();
        careerColumn.setCellValueFactory(new PropertyValueFactory<Career,String>("careerName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Career,String>("description"));
        salaryRangeColumn.setCellValueFactory(new PropertyValueFactory<Career,String>("salaryRange"));
        
        careerTable.setItems(listOfCareers);
        
        if(PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser().getProfileType()!=3){
            postBtn.setDisable(true);
        }
        
        User testUser = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getLoggedUser();
        checkScores.testPersValues(testUser);
    
        listOfJobs.add(checkScores.getRecommendedJob1());
        listOfJobs.add(checkScores.getRecommendedJob2());
    
         recommendedJobs.setItems(listOfJobs);
    }
    
    public void handlePostCareerButtonAction(){
        Career newCareer = new Career(careerTxt.getText(),descriptionTxt.getText(),salaryRangeTxt.getText());
        Stage theStage = (Stage) postBtn.getScene().getWindow();
        CareerCntl.getCareerCntl(theStage).addCareer(newCareer); 
    }
    
    public void handleBackButtonAction(){
        Stage theStage = (Stage) backBtn.getScene().getWindow();
        theStage.hide();
        CareerCntl.getCareerCntl(theStage).getNavCntl(theStage);
    }
    
}
