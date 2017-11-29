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
    
    
    public PersistentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
    }
    
    public UserList getuserList(){
        return theUserList;
    }
    
}
