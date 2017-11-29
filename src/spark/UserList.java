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
public class UserList implements Serializable {
    private ArrayList <User> theUserList;
    
    public UserList(){
        theUserList = new ArrayList();
        User User1 = new User("bob94","PassWord", "Bob", "Jones", "10/10/1994", "none","random bio info", 1);
        User User2 = new User("JohnS","Example", "John", "Smith", "8/12/1990", "Accountant","other information", 2);
        User User3 = new User("AnotherName","Words", "Another", "Name", "1/1/1", "Software Developer" ,"info here", 3);
        theUserList.add(User1);
        theUserList.add(User2);
        theUserList.add(User3);
    }
    
    public boolean Authenticate(String attemptUserName, String attemptPassword){
        boolean result = false;
        
        for(int i=0; i < getTheUserList().size();i++){
            if(attemptUserName.equals(getTheUserList().get(i).getUserName())){
                if(attemptPassword.equals(getTheUserList().get(i).getPassword())){
                     result = true;
                }
            }
        }
        return result;
    }
    
    public void addUser(String UN, String PW, String FN, String LN, String DOB, String car, String bio, int type ){
        User newUser = new User(UN, PW, FN, LN, DOB, car, bio, type);
        theUserList.add(newUser);
    }
    
    public void printUser(int i){
        String fn;
        String ln;
        String bio;
        fn = getTheUserList().get(i).getFirstName();
        ln = getTheUserList().get(i).getLastName();
        bio = getTheUserList().get(i).getBio();
        System.out.println(fn+ " "+ ln+ " "+ bio);
    }

    /**
     * @return the theUserList
     */
    public ArrayList <User> getTheUserList() {
        return theUserList;
    }

    /**
     * @param theUserList the theUserList to set
     */
    public void setTheUserList(ArrayList <User> theUserList) {
        this.theUserList = theUserList;
    }
}
