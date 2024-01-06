/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adminCDIbeans;

import client.Adminclient;
import ejb.AdminbeanLocal;
import entity.Orderdetail;
import entity.Ordermaster;
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
@Named(value = "orderpayment")
@RequestScoped
public class orderpayment {

    AdminbeanLocal abl;
    
   
    Adminclient user = new Adminclient();
    Response res;
    Ordermaster obj = new Ordermaster();
   
    GenericType<Ordermaster> om;
    Collection<Ordermaster> order;
    GenericType<Collection<Ordermaster>> omorder;

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

    public Ordermaster getObj() {
        return obj;
    }

    public void setObj(Ordermaster obj) {
        this.obj = obj;
    }

    public GenericType<Ordermaster> getOm() {
        return om;
    }

    public void setOm(GenericType<Ordermaster> om) {
        this.om = om;
    }

    public Collection<Ordermaster> getOrder() {
        return this.abl.getAllOrder();
    }

    public void setOrder(Collection<Ordermaster> order) {
        this.order = order;
    }

    public GenericType<Collection<Ordermaster>> getOmorder() {
        return omorder;
    }

    public void setOmorder(GenericType<Collection<Ordermaster>> omorder) {
        this.omorder = omorder;
    }
    

    
    public orderpayment() {
    }
    
}
