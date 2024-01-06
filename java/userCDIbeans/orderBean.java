/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package userCDIbeans;

import client.Userclient;
import ejb.UserbeanLocal;
import entity.Ordermaster;
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
@Named(value = "orderBean")
@RequestScoped
public class orderBean {

@EJB   
    UserbeanLocal ubl;
    
   
    Userclient user = new Userclient();
    Response res;
    Ordermaster obj = new Ordermaster();
    GenericType<Ordermaster> om;
    Collection<Ordermaster> order;
    GenericType<Collection<Ordermaster>> omorder;

    Integer productId, userId, orderId;
    Double discount,totalAmount;

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
        return this.ubl.getAllOrder();
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    public orderBean() {
    }
     public Ordermaster findorderBysid(Integer orderId) {
        om = new GenericType<Ordermaster>(){};
        res = user.getOById(Response.class, orderId.toString());
        obj = res.readEntity(om);
        return obj;
    }
     
     public String addorder() {
        this.ubl.inOrderMaster(userId, productId, discount, totalAmount);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/Admin/ViewSurvey.xhtml?faces-redirect=true";
    }
     
     public String delOrder(){
         this.ubl.delOrderMaster(orderId, userId);
         return "/AdminSide/ViewSurvey.xhtml?faces-redirect=true";
     }
}
