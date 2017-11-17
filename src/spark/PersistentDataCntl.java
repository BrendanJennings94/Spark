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
public class PersistentDataCntl {
    
    private static PersistentDataCntl thePersistentDataCntl;
    private PersistentDataCollection thePeristentDataCollection;
    
    private PersistentDataCntl(){
        if(thePeristentDataCollection == null){
            thePeristentDataCollection = new PersistentDataCollection();
        }
    }
    
    public static PersistentDataCntl getPersistentDataCntl(){
        if(thePersistentDataCntl == null){
            thePersistentDataCntl = new PersistentDataCntl();
        }
        return thePersistentDataCntl;
    }
    
    public PersistentDataCollection getPeristentDataCollection(){
        return thePeristentDataCollection;
    }
    
   
    
}
