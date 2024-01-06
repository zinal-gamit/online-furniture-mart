/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.AdminbeanLocal;
import entity.Billmaster;
import entity.Feedback;
import entity.Orderdetail;
import entity.Ordermaster;
import entity.Paymentmaster;
import entity.Productcategory;
import entity.Productmaster;
import entity.Usermaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Zinal
 */
@Path("adminRest")
@RequestScoped
public class adminRest {
    
      @EJB AdminbeanLocal ejb;

    @Context
    private UriInfo context;

   
    public adminRest() {
    }
    
      @POST
@Path("Register/{userName}/{password}/{email}/{firstName}/{lastName}/{MobileNo}/{address}/{city}/{pincode}/{state}/{country}")
       @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
       public void Register(
    @PathParam("userName") String userName,
    @PathParam("password") String password,
    @PathParam("email") String email,
    @PathParam("firstName") String firstName,
    @PathParam("lastName") String lastName,
    @PathParam("MobileNo") Integer MobileNo,
    @PathParam("address") String address,
    @PathParam("city") String city,
    @PathParam("pincode") Integer pincode,
    @PathParam("state") String state,
    @PathParam("country") String country
) {
    ejb.Register(userName, password, email, firstName, lastName, MobileNo, address, city, pincode, state, country);
            }
    
      @POST
    @Path("/insertbill/{userId}/{orderId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertbill(@PathParam("userId") Integer userId,@PathParam("orderId") Integer orderId,@PathParam("firstName") String firstName, @PathParam("description") String description, @PathParam("grandAmount") Double grandAmount, @PathParam("paymentType") String paymentType ) {
        ejb.addBill(userId, orderId, firstName, description, grandAmount, paymentType);
    }
    
     @GET
    @Path("/getBill")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Billmaster> getBill(){
        return ejb.getAllBill();
    }
    
     @GET
    @Path("/getBillById/{billId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billmaster getById(@PathParam("billId") Integer billId) {
        return ejb.getBillByid(billId);
    }
    
    @POST
    @Path("/addcat")
    @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
    public void addcat(Productcategory cat ) {
        ejb.addCategory(cat.getCategoryName(), cat.getCategoryDescription());
    }
    
    @PUT
    @Path("/updatecat/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatecat(@PathParam("categoryId") Integer categoryId, @PathParam("categoryName") String categoryName, @PathParam("categoryDescription") String categoryDescription) {
        ejb.updateCategory(categoryId, categoryName ,categoryDescription );
    }
    
    @DELETE
        @Path("/deletecat/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
      public void deletecat(@PathParam("categoryId") Integer categoryId) {
        ejb.delCategory(categoryId);
    }
    
    @GET
    @Path("/getCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productcategory> getcategory(){
        return ejb.getAllcategory();
    }
    
    @GET
    @Path("/getCatById/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productcategory getCatById(@PathParam("categoryId") int categoryId){
        return ejb.getByid(categoryId);
    }
    
    
    
       @GET
    @Path("/getAllFeedback")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Feedback> getFeedback(){
        return ejb.getallFeedback();
    }
    
      @GET 
    @Path("/getAllOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Ordermaster> getAllOrder(){
        return ejb.getAllOrder();
    }
    
      @GET 
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orderdetail> getAll(){
        return ejb.getAll();
    }
    
    @GET
    @Path("/getAllPay")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Paymentmaster> getAllPayment(){
        return ejb.getAllPayment();
    }
@POST
    @Path("/InsertPro/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response InsertPro(@PathParam("categoryId")Integer categoryId,Productmaster p){
        if(true){
            ejb.addProduct(p.getProductName(),
                p.getProductDescription(),
                p.getProductImage(),
                p.getTotalAmount(),
                p.getDiscount(),
                p.getDiscountAmount(),
                p.getTaxAmount(), 
                p.getGstAmount(), 
                p.getSgstAmount(),
                p.getGrandAmount() , 
                p.getUnit(),
                p.getProductStatus(),
                categoryId);
            String message = "Product is added";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        }
    }
        
   @POST
    @Path("/updatePro/{productId}/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePro(@PathParam("productId")Integer productId,@PathParam("categoryId")Integer categoryId,Productmaster p){
        if(ejb.updateproduct(
                productId,
                p.getProductName(),
                p.getProductDescription(),
                p.getProductImage(),
                p.getTotalAmount(),
                p.getDiscount(),
                p.getDiscountAmount(),
                p.getTaxAmount(), 
                p.getGstAmount(), 
                p.getSgstAmount(),
                p.getGrandAmount() , 
                p.getUnit(),
                p.getProductStatus(),
                    categoryId   )){
            String message = "Product is updated";
            return Response.status(Response.Status.OK).entity(message).build();
        } else {
            return Response.notModified().build();
        }
    }
    @DELETE
    @Path("/delpro/{productId}/{CategoryId}")
    @Produces(MediaType.APPLICATION_JSON)
     public void delpro(@PathParam("productId") Integer productId,@PathParam("CategoryId") Integer CategoryId ) {
        ejb.delproduct(productId,CategoryId);
    }


    @GET
    @Path("/getAllProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productmaster> getAllProduct(){
        return ejb.getallproduct();
    }
    
    @GET
    @Path("/getProById/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productmaster getProById(@PathParam("productId") Integer productId){
        return ejb.getprobyid(productId);
    }    
    
    
    @GET
    @Path("/getAllUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usermaster> getAllUser(){
        return ejb.getalluser();
    }
    
    @GET
    @Path("/getUById/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usermaster getUbyid(@PathParam("userId")Integer userId){
        return ejb.getrbyId(userId);
    }

    
    
   
}
