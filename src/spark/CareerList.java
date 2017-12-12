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
public class CareerList implements Serializable{
    
    private ArrayList <Career> theCareerList;
    
    public CareerList(){
        theCareerList = new ArrayList();
        Career career1 = new Career("SoftWare Development","develop code for commercial software", "40,000-100,000");
        Career career2 = new Career("Architect","Design buildings", "80,000 - 150,000");
        Career career3 = new Career("Scientist", "Discover and prove scientific phenomenon", "200,000 - 300,000");
        
        theCareerList.add(career1);
        theCareerList.add(career2);
        theCareerList.add(career3);
    }
    
    public ObservableList<Career> getCareerData(){
        ObservableList<Career> theListOfCareers;
        List<Career> careerList = (List<Career>) theCareerList;
        theListOfCareers = FXCollections.observableList(careerList);
        return theListOfCareers;
    }
    
}
