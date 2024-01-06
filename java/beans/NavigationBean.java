/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zinal
 */
@Named(value = "navigationBean")
@RequestScoped
public class NavigationBean {

    String Admin;
    String User;
    public NavigationBean() {
    }
     public String checkAdmin()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

         Admin = (String) session.getAttribute("Admin");
        if (Admin == null) {
            // Redirect to the login page
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/Login.jsf");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception as needed
            }
            return "/login.jsf?faces-redirect=true";
        }
         return "successOutcome";
    }
    
    public String checkUser()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

         User = (String) session.getAttribute("User");
        if (User == null) {
            // Redirect to the login page
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/Login.jsf");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception as needed
            }
            return "/login.jsf?faces-redirect=true";
        }
         return "successOutcome";
    }
    
}
