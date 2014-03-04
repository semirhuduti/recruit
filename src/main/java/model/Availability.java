/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Availability is a Persistence Entity used to store data about when the recrit 
 * is available to work.
 * 
 *
 * @author Semir, Dan & Milos
 */
@Entity
@Table(catalog = "recruit", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Availability.findAll", query = "SELECT a FROM Availability a"),
    @NamedQuery(name = "Availability.findByAvailabilityId", query = "SELECT a FROM Availability a WHERE a.availabilityId = :availabilityId"),
    @NamedQuery(name = "Availability.findByFromDate", query = "SELECT a FROM Availability a WHERE a.fromDate = :fromDate"),
    @NamedQuery(name = "Availability.findByToDate", query = "SELECT a FROM Availability a WHERE a.toDate = :toDate")})
public class Availability implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "availability_id", nullable = false)
    private Long availabilityId;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne
    private Person personId;

    /**
     * Contructor whithout an argument
     */
    public Availability() {
    }

    /**
     * Constructor whith the Long parameter availability specifying the PK for 
     * the entity.
     * 
     * @param availabilityId 
     */
    public Availability(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    /**
     * Get method to fetch availabilityId which is the PK for the Entity.
     * 
     * @return Long object availabilityId
     */
    public Long getAvailabilityId() {
        return availabilityId;
    }

    /**
     * Sets the PK availability to the value of the parameter.
     * 
     * @param availabilityId A new Long PK for the Entity
     */
    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    /**
     * Get method to fetch the date from which the recruit can start working
     * 
     * @return  Date object fromDate
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * Sets the date from which the recruit can start working to the value 
     * of the parameter.
     * 
     * @param fromDate Date object specifying when the recruit can start working
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Get method to fetch Date object toDate which is the final date which the 
     * recruit is available.
     * 
     * @return Date object specifying when teh recruit is no longer available
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * Sets the Date object toDate which is the final date which the 
     * recruit is available.
     * 
     * @param toDate the Date object to which the recruit is available
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    /**
     * Get method to fetch Person object personId which this entity is dependent
     * on.
     * 
     * @return Thhe foreign person 
     */
    public Person getPersonId() {
        return personId;
    }

    /**
     * Sets the person which this Entity is bound and dependent on.
     * 
     * @param personId A Person object
     */
    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (availabilityId != null ? availabilityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Availability)) {
            return false;
        }
        Availability other = (Availability) object;
        if ((this.availabilityId == null && other.availabilityId != null) || (this.availabilityId != null && !this.availabilityId.equals(other.availabilityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Availability[ availabilityId=" + availabilityId + " ]";
    }
    
}
