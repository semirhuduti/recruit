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
import model.CompetenceProfile;

/**
 * A DAO that is responsible for accessing and storing an CompetenceProfile object 
 * to the database.
 * 
 * @author Semir, Dan, Milos
 */
@ApplicationScoped
public class CompetenceProfileDAO implements CompetenceProfileDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    /**
     * Adds an CompetenceProfile object tot the database.
     * 
     * @param competencep  The CompetenceProfile object to be persisted
     */
    @Override
    public void addCompetenceProfile(CompetenceProfile competencep) {
        em.persist(competencep);
    }

    /**
     * Removes an CompetenceProfile object from the database.
     * 
     * @param competencep  The CompetenceProfile object to be found and removed from the DB.
     */
    @Override
    public void removeCompetenceProfile(CompetenceProfile competencep) {
        em.merge(competencep);
        em.remove(competencep);
    }

    /**
     * Finds an CompetenceProfile object in the DB by it's PK which is the Long Id
     * and and returns the object.
     * 
     * @param id    The Long PK to search for.
     * @return      The found object.
     */
    @Override
    public CompetenceProfile findByID(long id) {
        return em.find(CompetenceProfile.class, id);
    }

    /**
     * Finds all the CompetenceProfile objects and returns them.
     * 
     * @return  Returns a List with all the CompetenceProfile object from the DB.
     */
    @Override
    public List<CompetenceProfile> findAll() {
                TypedQuery<CompetenceProfile> query = em.createQuery(
                "SELECT g FROM CompetenceProfile g", CompetenceProfile.class);
        return query.getResultList();
    }

    /**
     * Searches for an CompetenceProfile object in the database by searching in 
     * the column "Name".
     * 
     * @param name  A String to search for in the column "Name".
     * @return      The found object.
     */
    @Override
    public CompetenceProfile findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
