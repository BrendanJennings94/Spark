/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author brend
 */
public class JobCntl {
    @FXML private Stage stage;
    private static JobCntl theJobCntl;
    private ObservableList<Job> theListOfJobs;
    
    private JobCntl(Stage theExistingStage){
        theListOfJobs = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheJobList().getJobData();
        stage = theExistingStage;
        setUpJobListScene();
        stage.show();
    }
    
    public static JobCntl getJobCntl(Stage theStage){
        if(theJobCntl != null){
            return theJobCntl;
        }else{
            theJobCntl = new JobCntl(theStage);
            return theJobCntl;
        }
    }
    
    @FXML public void setUpJobListScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("FXMLJobUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Jobs");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //adds job to the persistent data list, updates display
    public void addJob(Job newJob){
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheJobList().getJobData().add(newJob);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
        setUpJobListScene();
    }
    
    public void getNavCntl(Stage theStage){
        NavCntl.getNavCntl(theStage).setUpNavScene();
    }
    
    public ObservableList<Job> getListofJobs(){
        return theListOfJobs;
    }
    
    public Stage getStage(){
        return stage;
    }
    
   
    
}
