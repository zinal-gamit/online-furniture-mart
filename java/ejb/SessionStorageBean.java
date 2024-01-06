/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ejb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Vidhi
 */
@Named(value = "sessionStorageBean")
@SessionScoped
public class SessionStorageBean implements Serializable {

    
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * Creates a new instance of SessionStorageBean
     */
    public SessionStorageBean() {
    }
    
}
