/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adminCDIbeans;

import client.Adminclient;
import ejb.AdminbeanLocal;
import entity.Productcategory;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vidhi
 */
@Named(value = "categoryBean")
@RequestScoped
public class categoryBean {
    @EJB AdminbeanLocal abl;
    
   
    Adminclient admin = new Adminclient();
    Response res;
    Productcategory obj = new Productcategory();
    GenericType<Productcategory> pc;
    Collection<Productcategory> pro;
    GenericType<Collection<Productcategory>> pcpro;

    Integer categoryId;
    String categoryName,categoryDescription;

    public Adminclient getAdmin() {
        return admin;
    }

    public void setUser(Adminclient admin) {
        this.admin = admin;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Productcategory getObj() {
        return obj;
    }

    public void setObj(Productcategory obj) {
        this.obj = obj;
    }

    public GenericType<Productcategory> getPc() {
        return pc;
    }

    public void setPm(GenericType<Productcategory> pc) {
        this.pc = pc;
    }

    public Collection<Productcategory> getAllcategory() {
        return this.abl.getAllcategory();
    }

    public void setPro(Collection<Productcategory> pro) {
        this.abl.getAllcategory();
        this.pro = pro;
    }

    public GenericType<Collection<Productcategory>> getPcpro() {
        return pcpro;
    }

    public void setPmpro(GenericType<Collection<Productcategory>> pcpro) {
        this.pcpro = pcpro;
    }

    
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
  
    
    
    public categoryBean() {
    }
    
    public Productcategory findcatBysid(Integer categoryId) {
        pc = new GenericType<Productcategory>(){};
        res = admin.getCatById(Response.class, categoryId.toString());
        obj = res.readEntity(pc);
        return obj;
    }
    
    public String addCat(){
        System.out.println("categoryName:-"+categoryName);
        System.out.println("categoryDescription:-"+categoryDescription);
        abl.addCategory(categoryName, categoryDescription);
        return "category.xhtml";
    }
    
    public String updatecat(Integer categoryId , String categoryName , String categoryDescription){
        this.admin.updatecat(categoryId, categoryName);
        return "cartegory.xhtml";
    }
    
    public String delcat(Integer categoryId){
        this.abl.delCategory(categoryId);
                return "home.xhtml";
    }
    
}
