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
public class Actor  extends Person{
    
    public Actor(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Actor(String firstName, String lastName, String fullName) {
        super(firstName, lastName, fullName);
    }

    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
    }
      
}
