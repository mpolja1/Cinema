/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.Mario.Model;

/**
 *
 * @author mario
 */
public class UserApp {

    private final String userName;
    private final String password;

   
    public UserApp(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    
}
