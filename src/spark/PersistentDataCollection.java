/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.io.Serializable;

/**
 *
 * @author brend
 */
public class PersistentDataCollection implements Serializable {
    
     private UserList theUserList;
     private JobList theJobList;
     private CareerList theCareerList;
     private User loggedUser;
    
    
    public PersistentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
        
        if(theJobList == null){
            theJobList = new JobList();
        }
        
        if(theCareerList == null){
            theCareerList = new CareerList();
        }
    }
    
    public UserList getTheUserList() {
        return theUserList;
    }

    public JobList getTheJobList() {
        return theJobList;
    }  
    
    public CareerList getTheCareerList(){
        return theCareerList;
    }

    /**
     * @return the loggedUser
     */
    public User getLoggedUser() {
        return loggedUser;
    }

    /**
     * @param loggedUser the loggedUser to set
     */
    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
