/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.SecureClient;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Zinal
 */
@Named(value = "hello")
@RequestScoped
public class Hello {

  SecureClient cl;
    String secureHello;
    String message="";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
 
    
    
    
    public Hello() {
        
        
    }

    public String getSecureHello() {
        try{
         cl = new SecureClient();
         message="";
            System.out.println("inside Try Block");
        return cl.sayHello();
        }
        catch(Exception e)
        {
            System.out.println("inside Catch Block");
             message="";
            setMessage("You are Forbidden to access"); 
            System.err.println(message);
        }
        return "hello";
        
    }

    public void setSecureHello(String secureHello) {
        this.secureHello = secureHello;
    }
    
}
