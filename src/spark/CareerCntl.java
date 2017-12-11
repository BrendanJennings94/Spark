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
public class CareerCntl {
    @FXML private Stage stage;
    private static CareerCntl theCareerCntl;
    private ObservableList<Career> theListOfCareers;
    
    private CareerCntl(Stage theExistingStage){
        theListOfCareers = PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheCareerList().getCareerData();
        stage = theExistingStage;
        setUpCareerListScene();
        stage.show();
    }
    
    public static CareerCntl getCareerCntl(Stage theStage){
        if(theCareerCntl != null){
            return theCareerCntl;
        }else{
            theCareerCntl = new CareerCntl(theStage);
            return theCareerCntl;
        }
    }
    
    @FXML public void setUpCareerListScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("FXMLCareerUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Careers");
            stage.setScene(scene);
            stage.show();  
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //adds career to the persistent data list, updates screen to display
    public void addCareer(Career newCareer){
        PersistentDataCntl.getPersistentDataCntl().getPeristentDataCollection().getTheCareerList().getCareerData().add(newCareer);
        PersistentDataCntl.getPersistentDataCntl().writeSerializedDataModel();
        setUpCareerListScene();
    }
    
    public void getNavCntl(Stage theStage){
        NavCntl.getNavCntl(theStage).setUpNavScene();
    }
    
    public ObservableList<Career> getListOfCareers(){
        return theListOfCareers;
    }
    
    public Stage getStage(){
        return stage;
    }
    
}
