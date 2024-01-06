/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Billmaster;
import entity.Feedback;
import entity.Groupmaster;
import entity.Orderdetail;
import entity.Ordermaster;
import entity.Paymentmaster;
import entity.Productmaster;
import entity.Usermaster;
import entity.Wishlist;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
//import javax.security.enterprise.identitystore.Pbkdf2PasswordHashImpl;

/**
 *
 * @author Zinal
 */
@Stateless
public class Userbean implements UserbeanLocal {

     // Pbkdf2PasswordHashImpl pb;
    //PasswordHashCompare ph;

     @PersistenceContext(unitName = "persistence_unit")
    EntityManager em;
     @Inject
    private Validator validator;

    @Override
    public void Register(String userName, String password, String email, String firstName, String lastName, Integer MobileNo, String address, String city, Integer pincode, String state, String country) {
             
          try {
              System.out.println("In EJB :- " + email);
//            Groupmaster gm = em.find(Groupmaster.class,2);
            Groupmaster gm = em.find(Groupmaster.class, 2);
            Collection<Usermaster> userCollection = gm.getUsermasterCollection();
             //Hashing password
              //  pb = new Pbkdf2PasswordHashImpl();
              //  ph = new PasswordHashCompare();

              //  String enc = pb.generate(password.toCharArray());
                // Create Registermaster
             Usermaster u = new Usermaster();
              u.setUserName(userName);
          //  u.setPassword(enc);
          u.setPassword(password);
            u.setEmail(email);
            u.setFirstName(firstName);
            u.setLastName(lastName);
            u.setMobileNo(MobileNo);
            u.setAddress(address);
            u.setCity(city);
            u.setPincode(pincode);
            u.setState(state);
            u.setCountry(country);
            u.setCreatedAt(new Date());
             u.setGroupId(gm);
             userCollection.add(u);
             Set<ConstraintViolation<Usermaster>> violations = validator.validate(u);
        if (violations.isEmpty()) {
            // If no validation errors, proceed to persist the user or perform other actions
            // For example:
            // entityManager.persist(user);
        } else {
            // If there are validation errors, handle them accordingly
            for (ConstraintViolation<Usermaster> violation : violations) {
                String errorMessage = "Validation error at " + violation.getPropertyPath() + ": " + violation.getMessage();
                System.out.println(errorMessage);
                // You can perform error handling, logging, or throw an exception
            }
        }
            gm.setUsermasterCollection(userCollection);
            
            em.persist(u);
                
         } catch (Exception e) {
                System.out.println("In error");
                System.out.println(e);
         }

    }
    
    
     @Override
    public Integer getIdByEmail(String email) {
         try {
            Query query = em.createQuery("SELECT u.userId FROM Usermaster u WHERE u.email = :email");
            query.setParameter("email", email);
            return (Integer) query.getSingleResult();
        } catch (Exception e) {
            // Handle exceptions (e.g., NoResultException if no user found for the given email)
            return null; // Or throw an exception based on your error handling strategy
        }
    }

    @Override
    public Usermaster getrbyId(Integer userId) {
            Usermaster user = em.find(Usermaster.class, userId);
        return user;

    }

  

    @Override
    public Billmaster getBillByid(Integer billId) {
         Billmaster b = em.find(Billmaster.class,billId);
        return b;

    }


    @Override
    public void addWish(Integer productId, Integer userId, String size, Double grandAmount) {
          try {
            Usermaster u = em.find(Usermaster.class, userId);
            Productmaster p = em.find(Productmaster.class, productId);
            Collection<Wishlist> c1 = u.getWishlistCollection();
            Collection<Wishlist> c2 = p.getWishlistCollection();
            Wishlist c = new Wishlist();
            
          
                c.setSize(size);
               // c.setGrandAmount(grandAmount);
                c.setProductId(p);
                c.setUserId(u);
                c1.add(c);
                c2.add(c);
                u.setWishlistCollection(c1);
                p.setWishlistCollection(c2);
                em.persist(c);
                em.merge(u);
                em.merge(p);
       
        } catch (Exception e) {
            e.printStackTrace();
           
        }

    }

    @Override
    public void updateWish(Integer wishlistId, Integer productId, Integer userId, String size, Double grandAmount) {
           try {

            Wishlist c = em.find(Wishlist.class, wishlistId);
            Usermaster u = em.find(Usermaster.class, userId);
            Productmaster p = em.find(Productmaster.class, productId);
            Collection<Wishlist> c1 = u.getWishlistCollection();
            Collection<Wishlist> c2 = p.getWishlistCollection();
            if (c1.contains(c) && c2.contains(c)) {
                c.setSize(size);
                c.setGrandAmount(grandAmount);
                em.merge(c);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void delwish(Integer wishlistId, Integer productId, Integer userId) {
          try {
            Wishlist c = em.find(Wishlist.class, wishlistId);
            Usermaster u = em.find(Usermaster.class, userId);
            Productmaster p = em.find(Productmaster.class, productId);
            Collection<Wishlist> c1 = u.getWishlistCollection();
            Collection<Wishlist> c2 = p.getWishlistCollection();
            if (c1.contains(c) && c2.contains(c)) {

                em.remove(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public Collection<Wishlist> getAllWish() {
         Collection<Wishlist> c = em.createNamedQuery("Wishlist.findAll").getResultList();
        return c;    }

    @Override
    public Collection<Wishlist> getByUid(Integer userId) {
     Usermaster u = em.find(Usermaster.class, userId);
        Collection<Wishlist> c = u.getWishlistCollection();
        return c;

    }

    @Override
    public void insertFeedback(Integer userId, Integer productId, String message, String rating, String response) {
           Usermaster user = em.find(Usermaster.class, userId);
        Collection<Feedback> feed = user.getFeedbackCollection();
        Productmaster p = em.find(Productmaster.class, productId);
         Collection<Feedback> pro = p.getFeedbackCollection();
        Feedback f = new Feedback();
       f.setMessage(message);
        f.setRating(rating);
         f.setResponse(response);
        f.setUserId(user);
        f.setProductId(p);
        feed.add(f);
        pro.add(f);
        user.setFeedbackCollection(feed);
        p.setFeedbackCollection(feed);
        em.persist(f);
        em.merge(p);
        em.merge(user);
    }

    @Override
    public Collection<Feedback> getallFeedback() {
           Collection<Feedback> feed = em.createNamedQuery("Feedback.findAll").getResultList();
        return feed;
    }

    @Override
    public Feedback getfeedbackByid(Integer feedbackId) {
          Feedback feed = em.find(Feedback.class, feedbackId);
        return feed;

     }


     @Override
    public void inOrderMaster(Integer userId, Integer ProductId,  Double discount,Double totalAmount) {
         try {

            if (userId == null || totalAmount == null) {
                throw new IllegalArgumentException("Please Enter All Field");
            } else {
                double Discount = 0;
                double taxAmount = 0;
                double gstAmount = 0;
//                double sgstAmount = totalAmt * (sgst / 100);
                double sgstAmount = 0;
                double tax = 0;
                double gst = 0;
                double sgst = 0;
                Usermaster r = em.find(Usermaster.class, userId);
                Collection<Ordermaster> om = r.getOrdermasterCollection();
                Ordermaster o = new Ordermaster();
                  if (ProductId != null || discount != null) {
                    Productmaster p = em.find(Productmaster.class, ProductId);
                    if (discount.equals(p.getDiscount())) {
                        System.out.println(p.getDiscount());
                        discount = 0.10 * totalAmount;
                        tax = p.getTaxAmount();
                        gst = p.getGstAmount();
                        sgst = p.getSgstAmount();
                        o.setDiscount(discount);
                    }

                }
                

                taxAmount = totalAmount * (tax / 100);
                gstAmount = totalAmount * (gst / 100);
                sgstAmount = totalAmount * (sgst / 100);
                double grandAmount = totalAmount + taxAmount + gstAmount + sgstAmount - discount  ;
                o.setTotalAmount(totalAmount);
                o.setTaxAmount(taxAmount);
                o.setGstAmount(gstAmount);
                o.setSgstAmount((int) sgstAmount);
                o.setGrandAmount(grandAmount);
                o.setUserId(r);
                om.add(o);
                r.setOrdermasterCollection(om);
                em.persist(o);
                em.merge(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delOrderMaster(Integer orderId, Integer userId) {
        
        if (orderId == null || userId == null) {
            throw new IllegalArgumentException("Please Enter All Field");
        } else {

            Usermaster um = em.find(Usermaster.class, userId);
            Collection<Ordermaster> om = um.getOrdermasterCollection();
            Ordermaster o = em.find(Ordermaster.class, orderId);
            if (om.contains(o)) {
                em.remove(o);
            }
        }
    }

    @Override
    public Collection<Ordermaster> getAllOrder() {
         Collection<Ordermaster> o = em.createNamedQuery("Ordermaster.findAll").getResultList();
        return o;
    }

    @Override
    public Ordermaster getOrderById(Integer orderId) {
          Ordermaster o = em.find(Ordermaster.class, orderId);
        return o;
    }

    @Override
    public Collection<Ordermaster> getByUser(Integer userId) {
        
        Usermaster um = em.find(Usermaster.class, userId);
        Collection<Ordermaster> o = um.getOrdermasterCollection();
        return o; 
    }
    

     @Override
    public void addOrder(Integer quantity, Double grandAmount, Integer orderId, Integer productId) {
       try {
            if (quantity == null || grandAmount == null || orderId == null || productId == null) {
                throw new IllegalArgumentException("Please Enter All Field");
            } else {

                Productmaster p = em.find(Productmaster.class, productId);
                Collection<Orderdetail> pOrder = p.getOrderdetailCollection();
                Ordermaster o = em.find(Ordermaster.class, orderId);
                Collection<Orderdetail> oOrder = o.getOrderdetailCollection();

                Orderdetail order = new Orderdetail();
                order.setQuantity(quantity);
                order.setGrandAmount(grandAmount);
                order.setOrderId(o);
                order.setProductId(p);
                pOrder.add(order);
                oOrder.add(order);
                p.setOrderdetailCollection(pOrder);
                o.setOrderdetailCollection(oOrder);
                em.persist(order);
                em.merge(p);
                em.merge(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delOrder(Integer orderDetailId, Integer orderId, Integer productId) {
        try {

            if (orderDetailId == null || orderId == null || productId == null) {
                throw new IllegalArgumentException("Please Enter Brand Name and Image");
            } else {
                Orderdetail orid = em.find(Orderdetail.class, orderDetailId);
                Productmaster p = em.find(Productmaster.class, productId);
                Collection<Orderdetail> pOrder = p.getOrderdetailCollection();
                Ordermaster o = em.find(Ordermaster.class, orderId);
                Collection<Orderdetail> oOrder = o.getOrderdetailCollection();

                if (pOrder.contains(orid) && oOrder.contains(orid)) {
                    em.remove(orid);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

    }
        
        
    }

    @Override
    public Collection<Orderdetail> getAll() {
        Collection<Orderdetail> or = em.createNamedQuery("Orderdetail.findAll").getResultList();
        return or;
        
        
      }
     @Override
    public void insertpay(Integer orderId, Integer userId, String paymentMode, String upiId, Double grandAmount) {
        Paymentmaster p = new Paymentmaster();
        Ordermaster o = em.find(Ordermaster.class, orderId);
        Collection<Paymentmaster> payment = o.getPaymentmasterCollection();
        Usermaster u = em.find(Usermaster.class, userId);
        Collection<Paymentmaster> pay = u.getPaymentmasterCollection();
        p.setPaymentMode(paymentMode);
        p.setUpiId(upiId);
           p.setGrandAmount(grandAmount);
        p.setOrderId(o);
        p.setUserId(u);
        payment.add(p);
        pay.add(p);
        u.setPaymentmasterCollection(pay);
        o.setPaymentmasterCollection(payment);
        em.persist(p);
        em.merge(u);
        em.merge(o);

    }

    @Override
    public Collection<Paymentmaster> getAllPayment() {
      Collection<Paymentmaster> p =em.createNamedQuery("Paymentmaster.findAll").getResultList();
        return p;

    }

    @Override
    public Paymentmaster getPayById(Integer paymentId) {
           Paymentmaster p = em.find(Paymentmaster.class, paymentId);
        return p;    }

    @Override
    public Collection<Paymentmaster> getPByUid(Integer userId) {
      Usermaster user = em.find(Usermaster.class, userId);
     Collection<Paymentmaster> p = user.getPaymentmasterCollection();
     return p;
    }

  @Override
    public Collection<Productmaster> getallproduct() {
       Collection<Productmaster> pro = em.createNamedQuery("Productmaster.findAll").getResultList();
        return pro;

    }

    @Override
    public Productmaster getprobyid(Integer productId) {
          Productmaster pro = em.find(Productmaster.class, productId);
        return pro;
    }
     
     


}
