/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.Competence;
import model.Person;

/**
 * The Inteface which acts as an DTO for an CompetenceDAO object.
 * 
 * @author Semir, Dan, Milos
 */
public interface CompetenceDAOInterface {

    public void addCompetence(Competence competence);
    public void removeCompetence(Competence competence);
    public Competence findByID(long id);
    public List<Competence> findAll();
    public Competence findByName(String name);

}
