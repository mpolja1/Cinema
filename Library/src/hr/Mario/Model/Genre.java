/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.Mario.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author mario
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Genre {

    private static final String DEL = ",";

    private  int id;
     @XmlElement(name = "name")
    private String name;
   

    public Genre(int id, String name) {
        this(name);
        this.id = id;
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
    public static Genre ParseGenre(String line) {

        String[] details = line.split(DEL);
        
        return new Genre(
                details[0]
        );
    }
  
    
    @Override
    public String toString() {
        return name ;
    }

}
