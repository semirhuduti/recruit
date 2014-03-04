/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Person;

/**
 * A DAO that is responsible for accessing and storing an Person object 
 * to the database.
 * 
 * @author Semir, Dan, Milos
 */
@ApplicationScoped
public class PersonDAO implements PersonDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    public PersonDAO() {

    }

    /**
     * Adds an Person object tot the database.
     * 
     * @param person  The Person object to be persisted
     */
    @Override
    public void addPerson(Person person) {
        System.out.println("Person in DAO" + person.toString());
        System.out.println("EM null ? " + (em==null));
        em.persist(person);

    }

    /**
     * Finds all the Person objects and returns them.
     * 
     * @return  Returns a List with all the Person object from the DB.
     */
    @Override
    public List<Person> findAll() {
        TypedQuery<Person> query = em.createQuery(
                "SELECT g FROM Person g", Person.class);
        return query.getResultList();
    }

    /**
     * Removes an Person object from the database.
     * 
     * @param person  The Person object to be found and removed from the DB.
     */
    @Override
    public void removePerson(Person person) {
        em.merge(person);
        em.remove(person);
    }

    /**
     * Finds an Person object in the DB by it's PK which is the Long Id
     * and and returns the object.
     * 
     * @param id    The Long PK to search for.
     * @return      The found object.
     */
    @Override
    public Person findByID(long id) {
        return em.find(Person.class, id);

    }

    /**
     * Searches for an Person object in the database by searcing in the
     * column "Username".
     * 
     * @param username  A String to search for in the column "Username".
     * @return          The found object.
     */
    @Override
    public Person findByUsername(String username) {
        return em.createQuery("SELECT p FROM person WHERE person.username = " + username, Person.class).getSingleResult();
    }
}
