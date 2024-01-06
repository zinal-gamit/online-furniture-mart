/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import record.keeprecord;

/**
 *
 * @author Zinal
 */
@Named(value = "loginbean")
@RequestScoped
public class Loginbean {
 private String errorstatus = keeprecord.getErrorStatus();

    public String getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(String errorstatus) {
        this.errorstatus = errorstatus;
    }
 
 
 
    public Loginbean() {
    }
    
}
