/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vidhi
 */
@Entity
@Table(name = "productmaster")
@NamedQueries({
    @NamedQuery(name = "Productmaster.findAll", query = "SELECT p FROM Productmaster p"),
    @NamedQuery(name = "Productmaster.findByProductId", query = "SELECT p FROM Productmaster p WHERE p.productId = :productId"),
    @NamedQuery(name = "Productmaster.findByProductName", query = "SELECT p FROM Productmaster p WHERE p.productName = :productName"),
    @NamedQuery(name = "Productmaster.findByProductDescription", query = "SELECT p FROM Productmaster p WHERE p.productDescription = :productDescription"),
    @NamedQuery(name = "Productmaster.findByProductImage", query = "SELECT p FROM Productmaster p WHERE p.productImage = :productImage"),
    @NamedQuery(name = "Productmaster.findByTotalAmount", query = "SELECT p FROM Productmaster p WHERE p.totalAmount = :totalAmount"),
    @NamedQuery(name = "Productmaster.findByDiscount", query = "SELECT p FROM Productmaster p WHERE p.discount = :discount"),
    @NamedQuery(name = "Productmaster.findByDiscountAmount", query = "SELECT p FROM Productmaster p WHERE p.discountAmount = :discountAmount"),
    @NamedQuery(name = "Productmaster.findByTaxAmount", query = "SELECT p FROM Productmaster p WHERE p.taxAmount = :taxAmount"),
    @NamedQuery(name = "Productmaster.findByGstAmount", query = "SELECT p FROM Productmaster p WHERE p.gstAmount = :gstAmount"),
    @NamedQuery(name = "Productmaster.findBySgstAmount", query = "SELECT p FROM Productmaster p WHERE p.sgstAmount = :sgstAmount"),
    @NamedQuery(name = "Productmaster.findByGrandAmount", query = "SELECT p FROM Productmaster p WHERE p.grandAmount = :grandAmount"),
    @NamedQuery(name = "Productmaster.findByUnit", query = "SELECT p FROM Productmaster p WHERE p.unit = :unit"),
    @NamedQuery(name = "Productmaster.findByProductStatus", query = "SELECT p FROM Productmaster p WHERE p.productStatus = :productStatus"),
    @NamedQuery(name = "Productmaster.findByCreatedAt", query = "SELECT p FROM Productmaster p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Productmaster.findByUpdatedAt", query = "SELECT p FROM Productmaster p WHERE p.updatedAt = :updatedAt")})
public class Productmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productId")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "productName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "productDescription")
    private String productDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "productImage")
    private String productImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalAmount")
    private double totalAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private double discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discountAmount")
    private double discountAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxAmount")
    private double taxAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gstAmount")
    private double gstAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sgstAmount")
    private double sgstAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grandAmount")
    private double grandAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit")
    private int unit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "productStatus")
    private String productStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Feedback> feedbackCollection;
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @ManyToOne(optional = false)
    private Productcategory categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Wishlist> wishlistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Orderdetail> orderdetailCollection;

    public Productmaster() {
    }

    public Productmaster(Integer productId) {
        this.productId = productId;
    }

    public Productmaster(Integer productId, String productName, String productDescription, String productImage, double totalAmount, double discount, double discountAmount, double taxAmount, double gstAmount, double sgstAmount, double grandAmount, int unit, String productStatus, Date createdAt) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.discountAmount = discountAmount;
        this.taxAmount = taxAmount;
        this.gstAmount = gstAmount;
        this.sgstAmount = sgstAmount;
        this.grandAmount = grandAmount;
        this.unit = unit;
        this.productStatus = productStatus;
        this.createdAt = createdAt;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(double gstAmount) {
        this.gstAmount = gstAmount;
    }

    public double getSgstAmount() {
        return sgstAmount;
    }

    public void setSgstAmount(double sgstAmount) {
        this.sgstAmount = sgstAmount;
    }

    public double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(double grandAmount) {
        this.grandAmount = grandAmount;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    public Productcategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Productcategory categoryId) {
        this.categoryId = categoryId;
    }

    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productmaster)) {
            return false;
        }
        Productmaster other = (Productmaster) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productmaster[ productId=" + productId + " ]";
    }
    
}
