/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author brend
 */
public class JobList implements Serializable {

    private ArrayList <Job> theJobList;
    
    public JobList(){
        theJobList = new ArrayList();
    }
    
}
