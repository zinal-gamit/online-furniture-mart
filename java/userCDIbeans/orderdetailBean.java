/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package userCDIbeans;

import client.Userclient;
import ejb.UserbeanLocal;
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
@Named(value = "orderdetailBean")
@RequestScoped
public class orderdetailBean {
 UserbeanLocal ubl;
    
   
    Userclient user = new Userclient();
    Response res;
    Orderdetail obj = new Orderdetail();
    GenericType<Orderdetail> od;
    Collection<Orderdetail> orderd;
    GenericType<Collection<Orderdetail>> odorder;

    Integer productId, userId, orderDeatilId,quantity;
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
        return orderd;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderDeatilId() {
        return orderDeatilId;
    }

    public void setOrderdeatilId(Integer orderDeatilId) {
        this.orderDeatilId = orderDeatilId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(Double grandAmount) {
        this.grandAmount = grandAmount;
    }
    
    
    public orderdetailBean() {
    }
    
    
     
     public String addorder() {
        this.ubl.addOrder(quantity, grandAmount, userId, productId);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/Admin/ViewSurvey.xhtml?faces-redirect=true";
    }
     
     public String delOrder(){
         this.ubl.delOrder(orderDeatilId, userId, productId);
         return "/AdminSide/ViewSurvey.xhtml?faces-redirect=true";
     }
}
