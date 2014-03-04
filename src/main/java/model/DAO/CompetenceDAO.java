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
import model.Competence;

/**
 * A DAO that is responsible for accessing and storing an Competence object 
 * to the database.
 * 
 * @author Semir, Dan, Milos
 */
@ApplicationScoped
public class CompetenceDAO implements CompetenceDAOInterface {

    
    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    /**
     * Adds an Competence object tot the database.
     * 
     * @param competence  The Competence object to be persisted
     */
    @Override
    public void addCompetence(Competence competence) {
        em.persist(competence);
    }

    /**
     * Removes an Competence object from the database.
     * 
     * @param competence  The Competence object to be found and removed from the DB.
     */
    @Override
    public void removeCompetence(Competence competence) {
        em.merge(competence);
        em.remove(competence);
    }

    /**
     * Finds an Competence object in the DB by it's PK which is the Long Id
     * and and returns the object.
     * 
     * @param id    The Long PK to search for.
     * @return      The found object.
     */
    @Override
    public Competence findByID(long id) {
        return em.find(Competence.class, id);
    }

    /**
     * Finds all the Competence objects and returns them.
     * 
     * @return  Returns a List with all the Competence object from the DB.
     */
    @Override
    public List<Competence> findAll() {
        TypedQuery<Competence> query = em.createQuery(
                "SELECT g FROM Competence g", Competence.class);
        return query.getResultList();
    }

    /**
     * Searches for an Competence object in the database by searcing in the
     * Column "Name".
     * 
     * @param name  A String to search for in the column "Name".
     * @return      The found object.
     */
    @Override
    public Competence findByName(String name) {
        TypedQuery<Competence> query = em.createQuery(
                "SELECT c FROM Competence g WHERE competence.name = " + name, Competence.class);
        return query.getSingleResult();
    }

}
