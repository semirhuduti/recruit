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
import model.Availability;
import model.Competence;

/**
 * A DAO that is responsible for accessing and storing an Availability object 
 * to the database.
 *
 * @author Semir
 */
@ApplicationScoped
public class AvailabilityDAO implements AvailabilityDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    /**
     * Adds an Availability object tot the database.
     * 
     * @param availability  The availaility object to be persisted
     */
    @Override
    public void addAvailability(Availability availability) {
        em.persist(availability);
    }

    /**
     * Removes an availability object from the database.
     * 
     * @param availability  The availability object to be found and removed from the DB.
     */
    @Override
    public void removeAvailability(Availability availability) {
        em.merge(availability);
        em.remove(availability);
    }

    /**
     * Finds an Availability object in the DB by it's PK which is the Long Id
     * and and returns the object.
     * 
     * @param id    The Long PK to search for.
     * @return      The found object.
     */
    @Override
    public Availability findByID(long id) {
        return em.find(Availability.class, id);
    }

    /**
     * Finds all the Availability objects and returns them.
     * 
     * @return  Returns a List with all the Availability object from the DB.
     */
    @Override
    public List<Availability> findAll() {
        TypedQuery<Availability> query = em.createQuery(
                "SELECT g FROM Availibility g", Availability.class);
        return query.getResultList();
    }

}
