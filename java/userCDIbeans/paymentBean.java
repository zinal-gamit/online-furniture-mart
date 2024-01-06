/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package userCDIbeans;

import client.Userclient;
import ejb.UserbeanLocal;
import entity.Paymentmaster;
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
@Named(value = "paymentBean")
@RequestScoped
public class paymentBean {

   @EJB
  //  private AdminbeanLocal abl;
   
    UserbeanLocal ubl;
    
   
    Userclient user = new Userclient();
    Response res;
    Paymentmaster obj = new Paymentmaster();
    GenericType<Paymentmaster> pm;
    Collection<Paymentmaster> payment;
    GenericType<Collection<Paymentmaster>> pmpay;

    Integer orderId, userId,paymentId;
    String paymentMode,upiId;
    Double grandAmount;

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
        return this.ubl.getAllPayment();
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public Double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(Double grandAmount) {
        this.grandAmount = grandAmount;
    }
    
    
    public paymentBean() {
    }
    
     public Paymentmaster findPByUid(Integer userId,Integer paymentId) {
       pm = new GenericType<Paymentmaster>(){};
        res = user.getPayByUid(Response.class, userId.toString());
        res = user.getPayById(Response.class, paymentId.toString());
        obj = res.readEntity(pm);
        return obj;
    }
     
     public String addpay() {
        this.ubl.insertpay(orderId, userId, paymentMode, upiId, grandAmount);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/Admin/ViewSurvey.xhtml?faces-redirect=true";
    }
    
     
    
}
