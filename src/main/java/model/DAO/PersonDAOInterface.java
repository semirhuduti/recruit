/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.Person;

/**
 * The Inteface which acts as an DTO for an PersonDAO object.
 * 
 * @author Semir, Dan, Milos
 */
public interface PersonDAOInterface {
    
    public void addPerson(Person person);
    public void removePerson(Person person);
    public Person findByID(long id);
    public List<Person> findAll();
    public Person findByUsername(String username);
    
}
