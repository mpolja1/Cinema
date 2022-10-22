/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.Mario.Model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author mario
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Comparable<Person> {

    private static final String DELSPACE = "\\s+";
    private static final String DEL = ",";

    private int id;
    @XmlElement(name = "firstName")
    private String firstName;
    @XmlElement(name = "lastName")
    private String lastName;
    private String fullName;

    public Person(int id, String firstName, String lastName) {
        this(firstName, lastName);
        this.id = id;

    }

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String fullName) {
        this(firstName, lastName);
        this.fullName = fullName;
    }

    public Person(int id, String firstName, String lastName, String fullName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String firstName) {
        this.lastName = firstName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        fullName = this.firstName + " " + this.lastName;
        return fullName;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public static List<Person> ParsePerson(String person) {

        if (person.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        List<Person> persons = new ArrayList<>();
        String[] Arraydirector = person.trim().split(DEL);

        for (String string : Arraydirector) {
            String[] parsedDirector = string.trim().split(DELSPACE);

            if (Arraydirector.length == 1) {

                if (parsedDirector.length < 3) {
                    persons.add(new Person(
                            parsedDirector[0],
                            parsedDirector[1]
                    ));

                } else {
                    //directors with double lastName
                    persons.add(new Person(
                            parsedDirector[0],
                            parsedDirector[1] + "-" + parsedDirector[2]
                    ));
                }

            } else {
                persons.add(new Person(
                        parsedDirector[0],
                        parsedDirector[1]
                ));
            }

        }

        return persons;

    }

    @Override
    public int compareTo(Person o) {

        return firstName.compareTo(o.firstName);

    }

}
