package view;
import controller.Controller;
import java.util.Date;  
import javax.ejb.EJB;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Named;
import model.Availability;
import model.DAO.AvailabilityDAO;

@Named("calendarBean")
public class CalendarBean implements ActionListener {  
    @EJB
    Controller controller;
    @Inject
    AvailabilityDAO availabilitydao;
      
    private Date datefrom;  
    private Date dateto;

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }
    
    public void addAvailabilityToDB(){
        Availability a = new Availability();
        a.setFromDate(datefrom);
        a.setToDate(dateto);
        a.setPersonId(null);
        controller.setAvailibility(a);
    }

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        addAvailabilityToDB();
    }

       
}