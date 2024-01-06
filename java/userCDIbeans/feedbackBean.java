/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package userCDIbeans;

import client.Userclient;
import ejb.UserbeanLocal;
import entity.Feedback;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "feedbackBean")
@RequestScoped
public class feedbackBean {

    UserbeanLocal ubl;
    
   
    Userclient user = new Userclient();
    Response res;
    Feedback obj = new Feedback();
    GenericType<Feedback> fb;
    Collection<Feedback> feed;
    GenericType<Collection<Feedback>> fbfeed;

    Integer productId, userId, feedbackId;
    String message,rating,response;

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

    public Feedback getObj() {
        return obj;
    }

    public void setObj(Feedback obj) {
        this.obj = obj;
    }

    public GenericType<Feedback> getFb() {
        return fb;
    }

    public void setFb(GenericType<Feedback> fb) {
        this.fb = fb;
    }

    public Collection<Feedback> getFeed() {
        return this.ubl.getallFeedback();
    }

    public void setFeed(Collection<Feedback> feed) {
        this.feed = feed;
    }

    public GenericType<Collection<Feedback>> getFbfeed() {
        return fbfeed;
    }

    public void setFbfeed(GenericType<Collection<Feedback>> fbfeed) {
        this.fbfeed = fbfeed;
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

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
   
    
    public feedbackBean() {
    }
    
    public Feedback findbyfId(Integer feedbackId) {
        fb = new GenericType<Feedback>(){};
        res = user.getFeedById(Response.class, feedbackId.toString());
        obj = res.readEntity(fb);
        return obj;
    }
    
    public String Insertfeed() {
        this.ubl.insertFeedback(userId, productId, message, rating, response);
 //        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "user.xhtml";
    }
    
}
