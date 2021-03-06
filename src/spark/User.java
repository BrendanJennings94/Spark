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
public class User implements Serializable {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String career;
    private String bio;
    private int profileType;
    private ArrayList<Double> persTestValues = new ArrayList<Double>();
    
    public User(String theUserName, String thePassword, String theFN, String theLN, String theDOB,String theCareer, String theBio, int theProfType, ArrayList<Double> thePersTestValues){
        userName = theUserName;
        password = thePassword;
        firstName = theFN;
        lastName = theLN;
        dateOfBirth = theDOB;
        career = theCareer;
        bio = theBio;
        profileType = theProfType;
        if (thePersTestValues == null){
            persTestValues.add(0.0); // MOBILE
            persTestValues.add(0.0); // NOCT
            persTestValues.add(0.0); // GOAL
            persTestValues.add(0.0); // DETAIL
            persTestValues.add(0.0); // SOCIAL
            persTestValues.add(0.0); // FLEX
            persTestValues.add(0.0); // COMP
        }
        else {
            persTestValues = thePersTestValues;
        }
        
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return the profileType
     */
    public int getProfileType() {
        return profileType;
    }

    /**
     * @param profileType the profileType to set
     */
    public void setProfileType(int profileType) {
        this.profileType = profileType;
    }

    /**
     * @return the career
     */
    public String getCareer() {
        return career;
    }

    /**
     * @param career the career to set
     */
    public void setCareer(String career) {
        this.career = career;
    }

    /**
     * @return the persTestValues
     */
    public ArrayList<Double> getPersTestValues() {
        return persTestValues;
    }

    /**
     * @param persTestValues the persTestValues to set
     */
    public void setPersTestValues(ArrayList<Double> persTestValues) {
        this.persTestValues = persTestValues;
    }
    
}

