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
        theJobList.add(job1);
        theJobList.add(job2);
        theJobList.add(job3);
    }

    public ObservableList<Job> getJobData(){
        ObservableList<Job> theListOfJobs;
        List<Job> jobList = (List<Job>) theJobList;
        theListOfJobs = FXCollections.observableList(jobList);
        return theListOfJobs;
    }
    
}
