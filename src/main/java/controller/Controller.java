/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTOs.PersonDTO;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import model.DAO.PersonDAO;
import model.DAO.RoleDAO;
import model.Person;
import model.Role;

/**
 * Controller class which handles all calls from the RegisterBean class o the 
 * model.
 * 
 * @author Semir, Dan & Milos
 */
@Stateless
public class Controller {
   
    @Inject
    PersonDAO persondao;
    @Inject
    RoleDAO roledao;

    /**
     * The Controllers constructor
     */
    public Controller() {}

    /**
     * 
     * @param personDTO 
     */
    public void addPerson(PersonDTO personDTO) {
        Person person = new Person();
        
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setUsername(personDTO.getUsername());
        person.setPassword(personDTO.getPassword());
        person.setEmail(personDTO.getEmail());
        person.setSsn(personDTO.getSsn());
        person.setPersonId((long) 1);
        Role role = roledao.findByID(3);
        
        person.setRoleId(role);
        System.out.println("Person to be added to the pu : " + person.toString());

        persondao.addPerson(person);
    }

}
