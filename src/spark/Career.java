/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

/**
 *
 * @author brend
 */
public class Career {
    
    private String careerName;
    private String description;
    private String salaryRange;
    
    public Career(String theCareerName, String theDescription, String theSalaryRange){
        careerName = theCareerName;
        description = theDescription;
        salaryRange = theSalaryRange;
    }

    /**
     * @return the careerName
     */
    public String getCareerName() {
        return careerName;
    }

    /**
     * @param careerName the careerName to set
     */
    public void setCareerName(String careerName) {
        this.careerName = careerName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the salaryRange
     */
    public String getSalaryRange() {
        return salaryRange;
    }

    /**
     * @param salaryRange the salaryRange to set
     */
    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }
    
}
