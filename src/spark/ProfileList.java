/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.util.ArrayList;

/**
 *
 * @author brend
 */
public class ProfileList {
    private ArrayList <Profile> theProfileList;
    
    public ProfileList(){
        theProfileList = new ArrayList();
    }

    /**
     * @return the theProfileList
     */
    public ArrayList <Profile> getTheProfileList() {
        return theProfileList;
    }

    /**
     * @param theProfileList the theProfileList to set
     */
    public void setTheProfileList(ArrayList <Profile> theProfileList) {
        this.theProfileList = theProfileList;
    }
}
