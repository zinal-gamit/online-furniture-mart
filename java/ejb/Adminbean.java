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
import entity.Productcategory;
import entity.Productmaster;
import entity.Usermaster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;

/**
 *
 * @author Zinal
 */
@Stateless
public class Adminbean implements AdminbeanLocal {

    @PersistenceContext(unitName = "persistence_unit")
    EntityManager em;

    @Override
    public void Register(String userName, String password, String email, String firstName, String lastName, Integer MobileNo, String address, String city, Integer pincode, String state, String country) {

        try {
            
            Groupmaster gm = em.find(Groupmaster.class, 1);
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
            u.setGroupId(gm);
            userCollection.add(u);
            gm.setUsermasterCollection(userCollection);

            em.persist(u);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void addBill(Integer userId, Integer orderId, String firstName, String description, Double grandAmount, String paymentType) {
        Usermaster u = em.find(Usermaster.class, userId);
        Collection<Billmaster> bill = u.getBillmasterCollection();
        Ordermaster o = em.find(Ordermaster.class, orderId);
        Collection<Billmaster> obill = o.getBillmasterCollection();
        // Date date = new Date();
        Billmaster b = new Billmaster();
        b.setFirstName(firstName);
        b.setDescription(description);
        b.setPaymentType(paymentType);
        b.setGrandAmount(grandAmount);
        b.setOrderId(o);
        b.setUserId(u);
        bill.add(b);
        obill.add(b);
        o.setBillmasterCollection(obill);
        u.setBillmasterCollection(bill);
        em.persist(b);
        em.merge(o);
        em.merge(u);

    }

    @Override
    public Collection<Billmaster> getAllBill() {
        Collection<Billmaster> b = em.createNamedQuery("Billmaster.findAll").getResultList();
        return b;

    }

    @Override
    public Billmaster getBillByid(Integer billId) {
        Billmaster b = em.find(Billmaster.class, billId);
        return b;

    }

    @Override
    public void addCategory(String categoryName, String categoryDescription) {
        try{
        Productcategory c = new Productcategory();
        c.setCategoryName(categoryName);
        c.setCategoryDescription(categoryDescription);
        c.setCreatedAt(new Date());
        em.persist(c);
        System.out.println("In EJB categoryName :-" + categoryName);
        System.out.println("categoryDescription :-" + categoryDescription);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateCategory(Integer categoryId, String categoryName, String categoryDescription) {
        Productcategory c = em.find(Productcategory.class, categoryId);
        c.setCategoryName(categoryName);
        c.setCategoryDescription(categoryDescription);
        em.merge(c);
    }

    @Override
    public void delCategory(Integer categoryId) {
        Productcategory c = em.find(Productcategory.class, categoryId);
        em.remove(c);

    }

    @Override
    public Collection<Productcategory> getAllcategory() {
        Collection<Productcategory> c = em.createNamedQuery("Productcategory.findAll").getResultList();
        return c;
    }

    @Override
    public Productcategory getByid(Integer categoryId) {
        Productcategory c = em.find(Productcategory.class, categoryId);
        return c;
    }

    @Override
    public Collection<Feedback> getallFeedback() {
        Collection<Feedback> feed = em.createNamedQuery("Feedback.findAll").getResultList();
        return feed;
    }

    @Override
    public Collection<Ordermaster> getAllOrder() {
        Collection<Ordermaster> o = em.createNamedQuery("Ordermaster.findAll").getResultList();
        return o;
    }

    @Override
    public Collection<Orderdetail> getAll() {
        Collection<Orderdetail> or = em.createNamedQuery("Orderdetail.findAll").getResultList();
        return or;

    }

    @Override
    public Collection<Paymentmaster> getAllPayment() {
        Collection<Paymentmaster> p = em.createNamedQuery("Paymentmaster.findAll").getResultList();
        return p;

    }

   

    @Override
    public void delproduct(Integer productId, Integer categoryId) {
        Productmaster pro = em.find(Productmaster.class, productId);
        Productcategory cat = em.find(Productcategory.class, categoryId);
        Collection<Productmaster> product = cat.getProductmasterCollection();
        //Discount dis = em.find(Discount.class , discountId);
        //Collection<Productmaster> dproduct = dis.getProductmasterCollection();
        if (product.contains(pro)) {
            em.remove(pro);
        }

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

    @Override
    public Collection<Usermaster> getalluser() {
        Collection<Usermaster> user = em.createNamedQuery("Usermaster.findAll").getResultList();
        return user;

    }

    @Override
    public Usermaster getrbyId(Integer userId) {

        Usermaster user = em.find(Usermaster.class, userId);
        return user;
    }

    @Override
    public boolean addProduct(String productName, String productDescription, String productImage, Double totalAmount, Double discount, Double discountAmount, Double taxAmount, Double gstAmount, Double sgstAmount, Double grandAmount, Integer unit, String productStatus, Integer categoryId) {
        double DiscountAmount = (discount / 100) * totalAmount;
        double totalDiscoutPrice = totalAmount - discountAmount;
        
        System.out.println("in ejb"+productName);

        Productmaster pro = new Productmaster();
        Productcategory cat = em.find(Productcategory.class, categoryId);
        Collection<Productmaster> product = cat.getProductmasterCollection();

        pro.setProductName(productName);
        pro.setProductDescription(productDescription);
        pro.setProductImage(productImage);
        
        pro.setTotalAmount(totalAmount);
        pro.setDiscount(discount);
        pro.setTaxAmount(taxAmount);
        pro.setGstAmount(gstAmount);
        pro.setSgstAmount(sgstAmount);
        pro.setGrandAmount(grandAmount);
        pro.setUnit(unit);
        pro.setProductStatus(productStatus);
        pro.setCreatedAt(new Date());
        pro.setCategoryId(cat);
        product.add(pro);
        cat.setProductmasterCollection(product);
        System.out.println("productName="+productName);
        System.out.println("productDescription="+productDescription);

        em.merge(cat);
        em.persist(pro);
        return true;
    }

    @Override
    public boolean updateproduct(Integer productId, String productName, String productDescription, String productImage, Double totalAmount, Double discount,Double discountAmount, Double taxAmount, Double gstAmount, Double sgstAmount, Double grandAmount, Integer unit, String productStatus, Integer categoryId) {
      
        
       // double discountAmount = (discount / 100) * totalAmount;
        double totalDiscoutPrice = totalAmount - discountAmount;

        Productmaster pro = em.find(Productmaster.class, productId);
        Productcategory cat = em.find(Productcategory.class, categoryId);
        Collection<Productmaster> product = cat.getProductmasterCollection();

        if (product.contains(pro)) {
            pro.setProductName(productName);
            pro.setProductDescription(productDescription);
            pro.setProductImage(productImage);
            pro.setTotalAmount(totalAmount);
            pro.setDiscount(discount);
            pro.setDiscountAmount(discountAmount);
            pro.setTaxAmount(taxAmount);
            pro.setGstAmount(gstAmount);
            pro.setSgstAmount(sgstAmount);
            pro.setGrandAmount(grandAmount);
            pro.setUnit(unit);
            pro.setProductStatus(productStatus);
            pro.setCategoryId(cat);

            em.merge(pro);
        
        }


return true;
    }

    
}
