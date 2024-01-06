/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adminCDIbeans;


import client.Adminclient;
import ejb.AdminbeanLocal;
import entity.Billmaster;
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
@Named(value = "billBean")
@RequestScoped
public class billBean {

    @EJB
     AdminbeanLocal abl;
    
   
    Adminclient user = new Adminclient();
    Response res;
    Billmaster obj = new Billmaster();
    GenericType<Billmaster> bm;
    Collection<Billmaster> bill;
    GenericType<Collection<Billmaster>> bmbill;

    Integer userId,orderId,billId;
    String firstName,description,paymentType;
    Double grandAmount;

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
        return this.abl.getAllBill();
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

   


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(Double grandAmount) {
        this.grandAmount = grandAmount;
    }
    
  
    
    public billBean() {
    }
    
     public Billmaster findbillBysid(Integer billId) {
        bm = new GenericType<Billmaster>(){};
        res = user.getById(Response.class, billId.toString());
        obj = res.readEntity(bm);
        return obj;
    }
     
     public String addbill(){
         this.abl.addBill(userId, orderId, firstName, description, grandAmount, paymentType);
         return "index.xhtml";
     }
    
}
