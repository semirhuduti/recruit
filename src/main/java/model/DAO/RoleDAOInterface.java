/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.DAO;

import java.util.List;
import model.Role;

/**
 * The Inteface which acts as an DTO for an RoleDAO object.
 * 
 * @author Semir, Dan, Milos
 */
public interface RoleDAOInterface {
    
    public void addRole(Role role);
    public void removeRole(Role role);
    public Role findByID(long id);
    public List<Role> findAll();
    
}
