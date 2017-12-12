/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

/**
 *
 * @author Bryson Wilks
 */
public class CompatibiltyTest {
    private String recommendedJob1 = "";
    private String recommendedJob2 = "";
    
    public void testPersValues(User currentUser){ //
        if (currentUser.getPersTestValues().get(6) >= 26){ //Comp_Skill
            if (currentUser.getPersTestValues().get(3) >= 25.0){//Detail
                setRecommendedJob1("Engineer");
                setRecommendedJob2("Junior Software Dev");
            }
            else{
                setRecommendedJob1("Data Analyst");
                setRecommendedJob2("Assitant Technician");
            }
        }
        else if (currentUser.getPersTestValues().get(6) >= 15 && currentUser.getPersTestValues().get(6) < 26){ // Comp_Skill
            if (currentUser.getPersTestValues().get(0) >= 20.0){//Mobile
                setRecommendedJob1("Travel Specialist");
                setRecommendedJob2("Brand Ambassador");
                }
            else if (currentUser.getPersTestValues().get(4) > 10){//Social
                setRecommendedJob1("Manager");
                setRecommendedJob2("Teacher");
                }
            else if (currentUser.getPersTestValues().get(4) > 7.5){
                setRecommendedJob1("Relations consultant");
                setRecommendedJob2("Manager");
                }
            else if (currentUser.getPersTestValues().get(5) > 15){//FLEX
                setRecommendedJob1("Manager");
                setRecommendedJob2("Brand Ambassador");
                
                }
                
            }       
        }

    /**
     * @return the recommendedJob1
     */
    public String getRecommendedJob1() {
        return recommendedJob1;
    }

    /**
     * @param recommendedJob1 the recommendedJob1 to set
     */
    public void setRecommendedJob1(String recommendedJob1) {
        this.recommendedJob1 = recommendedJob1;
    }

    /**
     * @return the recommendedJob2
     */
    public String getRecommendedJob2() {
        return recommendedJob2;
    }

    /**
     * @param recommendedJob2 the recommendedJob2 to set
     */
    public void setRecommendedJob2(String recommendedJob2) {
        this.recommendedJob2 = recommendedJob2;
    }
    }


