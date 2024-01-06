/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adminCDIbeans;

import client.Adminclient;
import ejb.AdminbeanLocal;
import entity.Orderdetail;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "orderdetail")
@RequestScoped
public class orderdetail {

    AdminbeanLocal abl;
    
   
    Adminclient user = new Adminclient();
    Response res;
    Orderdetail obj = new Orderdetail();
   
    GenericType<Orderdetail> od;
    Collection<Orderdetail> orderd;
    GenericType<Collection<Orderdetail>> odorder;

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

    public Orderdetail getObj() {
        return obj;
    }

    public void setObj(Orderdetail obj) {
        this.obj = obj;
    }

    public GenericType<Orderdetail> getOd() {
        return od;
    }

    public void setOd(GenericType<Orderdetail> od) {
        this.od = od;
    }

    public Collection<Orderdetail> getOrderd() {
        return this.abl.getAll();
    }

    public void setOrderd(Collection<Orderdetail> orderd) {
        this.orderd = orderd;
    }

    public GenericType<Collection<Orderdetail>> getOdorder() {
        return odorder;
    }

    public void setOdorder(GenericType<Collection<Orderdetail>> odorder) {
        this.odorder = odorder;
    }
    
    
    public orderdetail() {
    }
    
}
