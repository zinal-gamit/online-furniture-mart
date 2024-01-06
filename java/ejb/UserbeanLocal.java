/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Billmaster;
import entity.Feedback;
import entity.Orderdetail;
import entity.Ordermaster;
import entity.Paymentmaster;
import entity.Productmaster;
import entity.Usermaster;
import entity.Wishlist;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Zinal
 */
@Local
public interface UserbeanLocal {
    public void Register(String userName,String password,String email,String firstName, String lastName,Integer MobileNo,  String address,String city,Integer pincode,String state,String country );
    
        Integer getIdByEmail(String email);
      Usermaster getrbyId(Integer userId);
        
     
     
      
      Billmaster getBillByid(Integer billId);
      
      void addWish(Integer productId,Integer userId,String size,Double grandAmount);
      
      void updateWish(Integer wishlistId,Integer productId,Integer userId,String size,Double grandAmount);
      
      void delwish(Integer wishlistId,Integer productId,Integer userId);
      
      Collection<Wishlist> getAllWish();
      
      Collection<Wishlist> getByUid(Integer userId);
      
      void insertFeedback(Integer userId,Integer productId,String message, String rating, String response);
      
      Collection<Feedback>getallFeedback();
      
      Feedback getfeedbackByid(Integer feedbackId);
      
       void inOrderMaster(Integer userId,Integer ProductId,Double discount,  Double totalAmount);

       void delOrderMaster(Integer orderId, Integer userId);

      Collection<Ordermaster> getAllOrder();
    
     Ordermaster getOrderById(Integer orderId);

      Collection<Ordermaster> getByUser(Integer userId);
      
       void addOrder(Integer quantity, Double grandAmount ,Integer orderId,Integer productId); 
       
      void  delOrder(Integer orderDetailId,Integer orderId,Integer productId);
  
      Collection<Orderdetail> getAll();
      
      void insertpay(Integer orderId,Integer userId,String paymentMode, String upiId , Double grandAmount);
      
      Collection<Paymentmaster> getAllPayment();
      
      Paymentmaster getPayById(Integer paymentId);
      
      Collection<Paymentmaster> getPByUid(Integer userId);
      
       Collection<Productmaster> getallproduct();
       
     Productmaster getprobyid(Integer productId); 
    
}
