/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DTOs.PersonDTO;
import controller.Controller;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Named;

/**
 * The Bean used as a "view" for Registering a new Job applicant.
 * @author Dan
 */
@Named("registerBean")
@RequestScoped
public class RegisterBean implements Serializable, ActionListener {

    @EJB
    private Controller controller;
    
    String email;
    String SSN;
    String password;
    String username;
    String firstName;
    String surName;
    
    public String getSurName() {
        return surName;
    }

    public void setSurName(String surname) {
        this.surName = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Adds a Person to the the Database.
     * 
     * @return  String used in the JSF to redirect to the new page.
     */
    public String addPersonToDB(){
        System.out.println("Is the controller null ? : " + (controller == null) );
        System.out.println(firstName + surName + SSN + email + username + password );
        
        PersonDTO person;
        person = new PersonDTO(firstName, surName, SSN, email, username, password);
        controller.setPerson(person);
        return "competence";
    }

    /**
     * Method used for.... Vafan är det här..?
     * 
     * @param event
     * @throws AbortProcessingException 
     */
    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
       addPersonToDB();
    }

}
