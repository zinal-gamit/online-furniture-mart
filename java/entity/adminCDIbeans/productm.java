/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adminCDIbeans;

import client.Adminclient;
import userCDIbeans.*;
import ejb.AdminbeanLocal;
import entity.Productmaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "productm")
@RequestScoped
public class productm {
    @EJB
       AdminbeanLocal abl;
    

    Response rs;
    Adminclient ac;
    Collection<Productmaster> product;
    GenericType<Collection<Productmaster>> gproduct;
    Productmaster p = new Productmaster();
    private String productName, productDescription, productStatus;
    Part productImage;
    Double totalAmount, discount, discoutAmount, taxAmount, gstAmount, sgstAmount, grandAmount ;
    Integer unit;
    Integer productId;
    Integer categoryId;
    
    public productm(){
            ac = new Adminclient();
        product = new ArrayList<>();
        gproduct = new GenericType<Collection<Productmaster>>() {
        };
        
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Adminclient getAc() {
        return ac;
    }

    public void setAc(Adminclient ac) {
        this.ac = ac;
    }

    public GenericType<Collection<Productmaster>> getGproduct() {
        return gproduct;
    }

    public void setGproduct(GenericType<Collection<Productmaster>> gproduct) {
        this.gproduct = gproduct;
    }

    public Productmaster getP() {
        return p;
    }

    public void setP(Productmaster p) {
        this.p = p;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Part getProductImage() {
        return productImage;
    }

    public void setProductImage(Part productImage) {
        this.productImage = productImage;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscoutAmount() {
        return discoutAmount;
    }

    public void setDiscoutAmount(Double discoutAmount) {
        this.discoutAmount = discoutAmount;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(Double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public Double getSgstAmount() {
        return sgstAmount;
    }

    public void setSgstAmount(Double sgstAmount) {
        this.sgstAmount = sgstAmount;
    }

    public Double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(Double grandAmount) {
        this.grandAmount = grandAmount;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    public void InsertPro(Integer categoryId) {
        if (productImage != null) {
            try {
                String fileName = productImage.getSubmittedFileName();
                // Specify the directory where you want to store the files
//                String uploadDirectory = "C:\\Users\\Zinal\\Documents\\NetBeansProjects\\FurnitureStore\\src\\main\\webapp\\images";
                String uploadDirectory = "C:\\Users\\Vidhi\\Documents\\NetBeansProjects\\FurnitureStore\\src\\main\\webapp\\images";
                File uploadDir = new File(uploadDirectory);
                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);
                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = productImage.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
//                this.p.setProductName(productName);
//               this.p.setProductDescription(productDescription);
//               this.p.setProductImage(productImage.getName());
//               this.p.setTotalAmount(totalAmount);
//               this.p.setDiscount(discount);
//                this.p.setDiscountAmount(discoutAmount);
//                this.p.setTaxAmount(taxAmount); 
//                this.p.setGstAmount(gstAmount); 
//                this.p.setSgstAmount(sgstAmount);
//                this.p.setGrandAmount(grandAmount); 
//                this.p.setUnit(unit);
//                this.p.setProductStatus(productStatus);
//                this.p.setCreatedAt(new Date());
//                rs = ac.InsertPro(p, categoryId);
//                if (rs != null) {
//                    System.out.println("success");
//                } else {
//                    System.out.println("error");
//                }
abl.addProduct(productName, productDescription, productImage.getName(), totalAmount, discount, discoutAmount, taxAmount, gstAmount, sgstAmount, grandAmount, unit, productStatus, 2);
                // You can use standard Java I/O operations to handle the file.
            } catch (IOException | ClientErrorException e) {
            }
        } else {
            System.out.println("File is null");
        }
        System.out.println("success");

    }
    
     public String updatePro(Integer productId, String productName, String productDescription, String productImage,Double totalAmount ,Double discount,Double discountAmount,Double taxAmount,Double gstAmount,Double sgstAmount,Double grandAmount, Integer unit, String productStatus, Integer categoryId) {
        this.p.getProductName();
               this.p.getProductDescription();
               this.p.getProductImage();
               this.p.getTotalAmount();
               this.p.getDiscount();
                this.p.getDiscountAmount();
                this.p.getTaxAmount(); 
                this.p.getGstAmount(); 
                this.p.getSgstAmount();
                this.p.getGrandAmount(); 
                this.p.getUnit();
                this.p.getProductStatus();
//        ac.updatePro(this.p,productId, categoryId);
        return "Product.jsf";
    }

   
    
}