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
import model.Role;

/**
 * A DAO that is responsible for accessing and storing an Role object 
 * to the database.
 * 
 * @author Semir, Dan, Milos
 */
@ApplicationScoped
public class RoleDAO implements RoleDAOInterface {

    @PersistenceContext(unitName = "JobFinderPU")
    private EntityManager em;

    public RoleDAO() {

    }

    /**
     * Adds an Role object tot the database.
     * 
     * @param role  The Role object to be persisted
     */
    @Override
    public void addRole(Role role) {
        System.out.println("Role in DAO" + role.toString());
        System.out.println("EM null ? " + (em==null));
        em.persist(role);

    }

    /**
     * Finds all the Role objects and returns them.
     * 
     * @return  Returns a List with all the Role object from the DB.
     */
    @Override
    public List<Role> findAll() {
        TypedQuery<Role> query = em.createQuery(
                "SELECT g FROM Role g", Role.class);
        return query.getResultList();
    }

    /**
     * Removes an Role object from the database.
     * 
     * @param role  The Role object to be found and removed from the DB.
     */
    @Override
    public void removeRole(Role role) {
        em.merge(role);
        em.remove(role);
    }

    /**
     * Finds an Role object in the DB by it's PK which is the Long Id
     * and and returns the object.
     * 
     * @param id    The Long PK to search for.
     * @return      The found object.
     */
    @Override
    public Role findByID(long id) {
        return em.find(Role.class, id);

    }
}
