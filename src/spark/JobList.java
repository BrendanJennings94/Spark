/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author brend
 */
public class JobList implements Serializable {

    private ArrayList <Job> theJobList;
    
    public JobList(){
        theJobList = new ArrayList();
        Job job1 = new Job("Junior Software Developer","Microsoft","50,000");
        Job job2 = new Job("Engineer","Ford","60,000");
        Job job3 = new Job("Data Analyst", "Bank of America", "40,000");
        Job job4 = new Job("Teacher", "Mary Winn Elementary School", "30,000");
        Job job5 = new Job("Photographer", "Melvin's Photography Studio", "35,000");
        Job job6 = new Job("Manager", "McCormick Place", "40,000");
        Job job7 = new Job("Assitant Technician", "Corpate Career Solutions", "65,000");
        Job job8 = new Job("Relations Consultant", "Smith and Smiths", "55,000");
        Job job9 = new Job("Marketing Relations ", "Chase of America", "60,000");
        Job job10 = new Job("Brand Ambassador", "Penn State University", "70,000");
        Job job11 = new Job("Travel Specialist", "Southwest Airlines", "62,000");
        
        theJobList.add(job1);
        theJobList.add(job2);
        theJobList.add(job3);
        theJobList.add(job4);
        theJobList.add(job5);
        theJobList.add(job6);
        theJobList.add(job7);
        theJobList.add(job8);
        theJobList.add(job9);
        theJobList.add(job10);
        theJobList.add(job11);
        
    }

    public ObservableList<Job> getJobData(){
        ObservableList<Job> theListOfJobs;
        List<Job> jobList = (List<Job>) theJobList;
        theListOfJobs = FXCollections.observableList(jobList);
        return theListOfJobs;
    }
    
}
