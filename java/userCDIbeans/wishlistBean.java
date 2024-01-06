/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package userCDIbeans;

import client.Userclient;
import ejb.AdminbeanLocal;
import ejb.UserbeanLocal;
import entity.Wishlist;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "wishlistBean")
@RequestScoped
public class wishlistBean {

     @EJB
  //  private AdminbeanLocal abl;
   
    UserbeanLocal ubl;
    
   
    Userclient user = new Userclient();
    Response res;
    Wishlist obj = new Wishlist();
    GenericType<Wishlist> wl;
    Collection<Wishlist> wish;
    GenericType<Collection<Wishlist>> wlwish;

    Integer productId, userId,categoryId,wishlistId;
    String size;
    Double grandAmount;

    public UserbeanLocal getUbl() {
        return ubl;
    }

    public void setUbl(UserbeanLocal ubl) {
        this.ubl = ubl;
    }

   

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Wishlist getObj() {
        return obj;
    }

    public void setObj(Wishlist obj) {
        this.obj = obj;
    }

    public GenericType<Wishlist> getWl() {
        return wl;
    }

    public void setWl(GenericType<Wishlist> wl) {
        this.wl = wl;
    }

    public Collection<Wishlist> getWish() {
        return this.ubl.getAllWish();
    }

    public void setWish(Collection<Wishlist> wish) {
        this.wish = wish;
    }

    public GenericType<Collection<Wishlist>> getWlwish() {
        return wlwish;
    }

    public void setWlwish(GenericType<Collection<Wishlist>> wlwish) {
        this.wlwish = wlwish;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(Double grandAmount) {
        this.grandAmount = grandAmount;
    }
    
    
    
    public wishlistBean() {
    }
    
     public Wishlist findcartBysid(Integer userId) {
        wl = new GenericType<Wishlist>(){};
        res = user.getCartByUid(Response.class, userId.toString());
        obj = res.readEntity(wl);
        return obj;
    }
     
     public String addwish() {
        this.ubl.addWish(wishlistId, userId, size, grandAmount);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/Admin/ViewSurvey.xhtml?faces-redirect=true";
    }
    public String Deletewish(Integer productId, Integer categoryId) {
        this.ubl.delwish(wishlistId, productId, userId);
//        this.admin.DeleteSurvey(sid.toString());
        return "/AdminSide/ViewSurvey.xhtml?faces-redirect=true";
    }

    public void UpdateSurveyActive(Integer wishlistId,Integer ProductId, Integer userId, String size, Double grandAmount) {
//        this.asb.UpdateDepartmentActive(id, Active);
        this.ubl.updateWish(wishlistId, ProductId, userId, size, grandAmount);
    }
    
    
}
