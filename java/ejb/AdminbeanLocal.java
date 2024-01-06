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
import entity.Productcategory;
import entity.Productmaster;
import entity.Usermaster;
import java.util.Collection;
import javax.ejb.Local;
import javax.servlet.http.Part;

/**
 *
 * @author Zinal
 */
@Local
public interface AdminbeanLocal {
     void Register(String userName,String password,String email,String firstName, String lastName,Integer MobileNo,  String address,String city,Integer pincode,String state,String country );

    void addBill(Integer userId,Integer orderId,String firstName,String description,Double grandAmount,String paymentType);
    
    Collection<Billmaster> getAllBill();
    
    Billmaster getBillByid(Integer billId);
    
    void addCategory(String categoryName,  String categoryDescription);
    
    void updateCategory(Integer categoryId,String categoryName, String categoryDescription);
    
    void delCategory(Integer categoryId);
    
     Collection<Productcategory> getAllcategory();
     
    Productcategory getByid(Integer categoryId);
    
     Collection<Feedback>getallFeedback();
     
     Collection<Ordermaster> getAllOrder();
     
      Collection<Orderdetail> getAll();
      
      Collection<Paymentmaster> getAllPayment();
      
      boolean addProduct(String productName,String productDescription, String productImage,Double totalAmount,Double discount,Double discountAmount,Double taxAmount,Double gstAmount,Double sgstAmount,Double grandAmount,Integer unit , String productStatus,Integer categoryId );
      
    boolean updateproduct(Integer productId,String productName,String productDescription, String productImage,Double totalAmount,Double discount,Double discountAmount,Double taxAmount,Double gstAmount,Double sgstAmount,Double grandAmount, Integer unit , String productStatus,Integer categoryId);
    
    void delproduct(Integer productId,Integer categoryId  );
    
    Collection<Productmaster> getallproduct();
    
    Productmaster getprobyid(Integer productId);
    
    Collection<Usermaster>  getalluser();
    
    Usermaster getrbyId(Integer userId);

    
}
