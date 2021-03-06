/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTOs.PersonDTO;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import model.Availability;
import model.Competence;
import model.CompetenceProfile;
import model.DAO.AvailabilityDAO;
import model.DAO.CompetenceDAO;
import model.DAO.CompetenceProfileDAO;
import model.DAO.PersonDAO;
import model.DAO.RoleDAO;
import model.Person;
import model.Role;
import view.CompetenceBean.CompetenceHolder;

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
    @Inject
    CompetenceDAO competencedao;
    @Inject
    AvailabilityDAO availabilitydto;
    @Inject
    CompetenceProfileDAO cpdao;
    
    PersonDTO personDTO;
    Availability availibility;
    List<CompetenceHolder> competenceHolder;

    public PersonDTO getPerson() {
        return personDTO;
    }

    public void setPerson(PersonDTO person) {
        this.personDTO = person;
    }

    public Availability getAvailibility() {
        return availibility;
    }

    public void setAvailibility(Availability availibility) {
        this.availibility = availibility;
    }

    public List<CompetenceHolder> getCompetenceHolder() {
        return competenceHolder;
    }

    public void setCompetenceHolder(List<CompetenceHolder> competenceHolder) {
        this.competenceHolder = competenceHolder;
    }

    /**
     * The Controllers constructor
     */
    public Controller() {}

    
    public void persistAll(){
        
        //Persist Person
        
        Person person = new Person();
        
        person.setFirstname(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setUsername(personDTO.getUsername());
        person.setUserpassword(personDTO.getPassword());
        person.setEmail(personDTO.getEmail());
        person.setSsn(personDTO.getSsn());
        person.setPersonId((long) 1);
        Role role = roledao.findByID(3);
        
        person.setRoleId(role);
        System.out.println("Person to be added to the pu : " + person.toString());

        persondao.addPerson(person);
        
        
        //Get Person ID
        
        
        
        //Persist Availibility
        availibility.setPersonId(person);
        availabilitydto.addAvailability(availibility);
        
        
        //Persist Competene
        
        for(int i = 0; i < competenceHolder.size(); i++ ){
            Competence c = new Competence();
            c.setCompetenceName(competenceHolder.get(i).getCompetenceName());
            competencedao.addCompetence(c);
        }

        //Get Competence ID 
        
        for(int i = 0; i < competenceHolder.size(); i++ ){
            CompetenceProfile cp = new CompetenceProfile();
            cp.setCompetenceId(competencedao.findByName(competenceHolder.get(i).getCompetenceName()));
            cp.setYearsOfExperience(competenceHolder.get(i).getYoe());
            cp.setPersonId(person);
            cpdao.addCompetenceProfile(cp);
        }
        
        //Persist Competence Profile
        
        

        
    }

}
