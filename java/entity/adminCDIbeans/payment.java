/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adminCDIbeans;

import client.Adminclient;
import ejb.AdminbeanLocal;
import entity.Paymentmaster;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "payment")
@RequestScoped
public class payment {

  AdminbeanLocal abl;
    
   
    Adminclient user = new Adminclient();
    Response res;
    Paymentmaster obj = new Paymentmaster();
   
    GenericType<Paymentmaster> pm;
    Collection<Paymentmaster> payment;
    GenericType<Collection<Paymentmaster>> pmpay;

    public AdminbeanLocal getAbl() {
        return abl;
    }

    public void setAbl(AdminbeanLocal abl) {
        this.abl = abl;
    }

    public Adminclient getUser() {
        return user;
    }

    public void setUser(Adminclient user) {
        this.user = user;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Paymentmaster getObj() {
        return obj;
    }

    public void setObj(Paymentmaster obj) {
        this.obj = obj;
    }

    public GenericType<Paymentmaster> getPm() {
        return pm;
    }

    public void setPm(GenericType<Paymentmaster> pm) {
        this.pm = pm;
    }

    public Collection<Paymentmaster> getPayment() {
        return this.abl.getAllPayment();
    }

    public void setPayment(Collection<Paymentmaster> payment) {
        this.payment = payment;
    }

    public GenericType<Collection<Paymentmaster>> getPmpay() {
        return pmpay;
    }

    public void setPmpay(GenericType<Collection<Paymentmaster>> pmpay) {
        this.pmpay = pmpay;
    }
    
    
    public payment() {
    }
    
}
