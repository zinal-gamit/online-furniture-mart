/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.UserbeanLocal;
import entity.Billmaster;
import entity.Feedback;
import entity.Orderdetail;
import entity.Ordermaster;
import entity.Paymentmaster;
import entity.Productmaster;
import entity.Wishlist;
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
@Path("useRest")
@RequestScoped
public class useRest {
   @EJB
      UserbeanLocal ucl;
    @Context
    private UriInfo context;

    public useRest() {
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
    ucl.Register(userName, password, email, firstName, lastName, MobileNo, address, city, pincode, state, country);
            }

    
     

    
      @GET
    @Path("/getBillById/{billId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billmaster getBillById(@PathParam("billId") Integer billId) {
        return ucl.getBillByid(billId);
    }
    
   
       @POST
    @Path("/addWish/{productId}/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
      public void addWish(@PathParam("productId") Integer productId, @PathParam("userId") Integer userId,@PathParam("size") String size,@PathParam("grandAmount") Double grandAmount) {
        ucl.addWish(productId, userId, size, grandAmount);
    }
    
    
    @PUT
    @Path("/updateWish{wishlistId}/{productId}/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateWish( @PathParam("wishlistId") Integer wishlistId,@PathParam("productId") Integer productId, @PathParam("userId") Integer userId,@PathParam("size") String size,@PathParam("grandAmount") Double grandAmount) {
       ucl.updateWish(wishlistId, productId, userId, size, grandAmount);
    }
    
     @DELETE
    @Path("/deleteWish/{wishlistId}/{productId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletecat(@PathParam("wishlistId") Integer wishlistId,@PathParam("productId") Integer productId,@PathParam("userId") Integer userId) {
        ucl.delwish(wishlistId, productId, userId);
    }

    
     @GET
    @Path("/getAllWish")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Wishlist> getAllCart() {
        return ucl.getAllWish();
    }
    
    @GET
    @Path("/getWishByUid/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Wishlist> getCartByUid(@PathParam("userId") Integer userId) {
        return ucl.getByUid(userId);
    }

    
     @POST
    @Path("/insertFeed/{userId}/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertFeed(@PathParam("userId") Integer userId, @PathParam("productId") Integer productId,@PathParam("message") String message,@PathParam("rating") String rating,@PathParam("response") String response ) {
       ucl.insertFeedback(userId, productId, message, rating, response);
    }
    
    
      @GET
    @Path("/getFeedById/{feedbackId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Feedback getFeedById(@PathParam("feedbackId") Integer feedbackId) {
        return ucl.getfeedbackByid(feedbackId);
    }
    
   
    
    @POST
    @Path("/inOrderMaster/{userId}/{ProductId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void inOrderMaster(@PathParam("userId") Integer userId, @PathParam("ProductId") Integer ProductId,@PathParam("discount") Double discount,@PathParam("totalAmount") Double totalAmount ) {
       ucl.inOrderMaster(userId, ProductId, discount, totalAmount);
    }
    
    
     @DELETE
    @Path("/delOrderMaster/{orderId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delOrderMaster(@PathParam("orderId") Integer orderId, @PathParam("userId") Integer userId) {
        ucl.delOrderMaster(orderId, userId);
    }
    
    @GET
    @Path("/getOById/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ordermaster getOById(@PathParam("orderId") Integer orderId) {
        return ucl.getOrderById(orderId);
    }
    
     @GET
    @Path("/getOByUid/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Ordermaster> getByUser(@PathParam("userId") Integer userId) {
        return ucl.getByUser(userId);
    }
    
     @POST
    @Path("/addOrder/{orderId}/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addOrder(@PathParam("orderId") Integer orderId, @PathParam("productId") Integer productId,@PathParam("quantity") Integer quantity,@PathParam("grandAmount") Double grandAmount ) {
       ucl.addOrder(quantity, grandAmount, orderId, productId);
    }
    
    @DELETE
    @Path("/delOrderMaster/{orderDetailId}/{orderId}/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delOrder(@PathParam("orderDetailId") Integer orderDetailId, @PathParam("orderId") Integer orderId, @PathParam ("productId") Integer productId ) {
        ucl.delOrder(orderDetailId, orderId, productId);
    }  
    
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Orderdetail> getAll() {
        return ucl.getAll();
    }
    
    
        
        @POST
    @Path("/InsertPay/{orderId}/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void InsertPay(@PathParam("orderId") Integer orderId, @PathParam("userId") Integer userId,@PathParam("paymentMode") String paymentMode,@PathParam("upiId") Integer upiId,@PathParam("grandAmount") Double grandAmount ) {
        ucl.insertpay(orderId, userId, paymentMode, paymentMode, grandAmount);
    }
    
     @GET
    @Path("/getById/{paymentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paymentmaster getPayById(@PathParam("paymentId") Integer paymentId) {
        return ucl.getPayById(paymentId);
    }
    
    @GET
    @Path("/getByUid/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Paymentmaster> getPayByUid(@PathParam("userId") Integer userId) {
        return ucl.getPByUid(userId);
    }
    
    
    @GET
    @Path("/getAllProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Productmaster> getAllProduct() {
        return ucl.getallproduct();
    }
    
     @GET
    @Path("/getProById/{ProductId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productmaster getProById(@PathParam("ProductId") Integer ProductId) {
        return ucl.getprobyid(ProductId);
    }
        

}
