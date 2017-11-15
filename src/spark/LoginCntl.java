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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class LoginCntl {
    
    @FXML private Label fail;
    @FXML private TextField userName;
    @FXML private PasswordField passField;
    private UserList list1;
    
    public LoginCntl(){
        list1 = new UserList();
    }
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event){
        String attUN = userName.getText();
        String attPass = passField.getText();
        if(requestAuthenticate(attUN, attPass)){
            Stage stage = (Stage) fail.getScene().getWindow();
            stage.hide();
            NavCntl theNavCntl = NavCntl.getNavCntl(stage);
        }
        else{
            userName.setText("");
            passField.setText("");
            fail.setVisible(true);
        }
    }

    public boolean requestAuthenticate(String attemptUN, String attemptPass){
        boolean result = false;
       result = getList1().Authenticate(attemptUN, attemptPass);
        return result;
    }
    
    /**
     * @return the fail
     */
   
    public UserList getList1() {
        return list1;
    }

    /**
     * @param list1 the list1 to set
     */
    public void setList1(UserList list1) {
        this.list1 = list1;
    }
}