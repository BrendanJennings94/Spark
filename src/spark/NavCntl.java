/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

/**
 *
 * @author brend
 */
public class NavCntl {
    @FXML private Stage stage;
    private static NavCntl theNavCntl;
     
    private NavCntl(Stage theExistingStage){
        stage = theExistingStage;
        setUpNavScene();
        stage.show();
        
    }
    
    public static NavCntl getNavCntl(Stage theStage){
        if(theNavCntl != null){
            return theNavCntl;
        }
        else{
            theNavCntl = new NavCntl(theStage);
            return theNavCntl;
        }
    }
    
    @FXML public void setUpNavScene(){
        Parent root;
        Scene scene;
        try{
        //Custom navigation view
        root = FXMLLoader.load(getClass().getResource("FXMLNavigationUI.fxml"));
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
            }
        
    }
    
    //restarts the application
    public void Logout() throws URISyntaxException, IOException{
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar = new File(Spark.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        /* is it a jar file? */
        if(!currentJar.getName().endsWith(".jar"))
          return;

        /* Build command: java -jar application.jar */
        final ArrayList<String> command = new ArrayList<String>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        final ProcessBuilder builder = new ProcessBuilder(command);
        builder.start();
        System.exit(0);
    }
    
    public void getJobCntl(Stage theStage){
        JobCntl.getJobCntl(theStage);
    }
    
    public void getCareerCntl(Stage theStage){
        CareerCntl.getCareerCntl(theStage);
    }

}
