/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package userCDIbeans;

import client.Userclient;
import ejb.UserbeanLocal;
import entity.Productmaster;

import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "productmaster")
@RequestScoped
public class productmaster {

     @EJB
  //  private AdminbeanLocal abl;
   
    UserbeanLocal ubl;
    
   
    Userclient user = new Userclient();
    Response res;
    Productmaster obj = new Productmaster();
    GenericType<Productmaster> pm;
    Collection<Productmaster> product;
    GenericType<Collection<Productmaster>> pmpro;

    Integer productId;

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

    public Productmaster getObj() {
        return obj;
    }

    public void setObj(Productmaster obj) {
        this.obj = obj;
    }

    public GenericType<Productmaster> getPm() {
        return pm;
    }

    public void setPm(GenericType<Productmaster> pm) {
        this.pm = pm;
    }

    public Collection<Productmaster> getProduct() {
        return this.ubl.getallproduct();
    }

    public void setProduct(Collection<Productmaster> product) {
        this.product = product;
    }

    public GenericType<Collection<Productmaster>> getPmpro() {
        return pmpro;
    }

    public void setPmpro(GenericType<Collection<Productmaster>> pmpro) {
        this.pmpro = pmpro;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    

    public productmaster() {
    }
    
    public Productmaster findPByUid(Integer productId) {
       pm = new GenericType<Productmaster>(){};
        res = user.getProById(Response.class, productId.toString());
        obj = res.readEntity(pm);
        return obj;
    }
    
}
