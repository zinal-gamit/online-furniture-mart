/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adminCDIbeans;

import ejb.AdminbeanLocal;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Zinal
 */
@Named(value = "feedback")
@RequestScoped
public class Feedback {

        Collection<entity.Feedback> feedbacks = null;
    @EJB AdminbeanLocal abl;

    public Collection<entity.Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Collection<entity.Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

   
    
    
    public Feedback() {
        
        
    }
    @PostConstruct
    public void initialise()
    {
        feedbacks = abl.getallFeedback();
    }
    
    
    
}
