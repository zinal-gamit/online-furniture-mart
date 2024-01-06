/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package userCDIbeans;

import client.Userclient;
import ejb.UserbeanLocal;
import entity.Billmaster;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "billCdi")
@RequestScoped
public class billCdi {

      UserbeanLocal ubl;
    
   
    Userclient user = new Userclient();
    Response res;
    Billmaster obj = new Billmaster();
    GenericType<Billmaster> bm;
    Collection<Billmaster> bill;
    GenericType<Collection<Billmaster>> bmbill;

    public UserbeanLocal getUbl() {
        return ubl;
    }

    public void setUbl(UserbeanLocal ubl) {
        this.ubl = ubl;
    }

    public Userclient getUser() {
        return user;
    }

    public void setUser(Userclient user) {
        this.user = user;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Billmaster getObj() {
        return obj;
    }

    public void setObj(Billmaster obj) {
        this.obj = obj;
    }

    public GenericType<Billmaster> getBm() {
        return bm;
    }

    public void setBm(GenericType<Billmaster> bm) {
        this.bm = bm;
    }

    public Collection<Billmaster> getBill() {
        return bill;
    }

    public void setBill(Collection<Billmaster> bill) {
        this.bill = bill;
    }

    public GenericType<Collection<Billmaster>> getBmbill() {
        return bmbill;
    }

    public void setBmbill(GenericType<Collection<Billmaster>> bmbill) {
        this.bmbill = bmbill;
    }
    
    
    
    public billCdi() {
    }
     public Billmaster findbillBybid(Integer billId) {
        bm = new GenericType<Billmaster>(){};
        res = user.getBillById(Response.class, billId.toString());
        obj = res.readEntity(bm);
        return obj;
    }
    
}
