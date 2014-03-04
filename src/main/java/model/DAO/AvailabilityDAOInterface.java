/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.Availability;


/**
 * The Inteface which acts as an DTO for an AvailabilityDAO object.
 * 
 * @author Semir, Dan, Milos
 */
public interface AvailabilityDAOInterface {

    public void addAvailability(Availability availability);
    public void removeAvailability(Availability availability);
    public Availability findByID(long id);
    public List<Availability> findAll();
}
