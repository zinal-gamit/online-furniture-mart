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

/**
 *
 * @author Vidhi
 */
@Entity
@Table(name = "ordermaster")
@NamedQueries({
    @NamedQuery(name = "Ordermaster.findAll", query = "SELECT o FROM Ordermaster o"),
    @NamedQuery(name = "Ordermaster.findByOrderId", query = "SELECT o FROM Ordermaster o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Ordermaster.findByTotalAmount", query = "SELECT o FROM Ordermaster o WHERE o.totalAmount = :totalAmount"),
    @NamedQuery(name = "Ordermaster.findByDiscount", query = "SELECT o FROM Ordermaster o WHERE o.discount = :discount"),
    @NamedQuery(name = "Ordermaster.findByTaxAmount", query = "SELECT o FROM Ordermaster o WHERE o.taxAmount = :taxAmount"),
    @NamedQuery(name = "Ordermaster.findByGstAmount", query = "SELECT o FROM Ordermaster o WHERE o.gstAmount = :gstAmount"),
    @NamedQuery(name = "Ordermaster.findBySgstAmount", query = "SELECT o FROM Ordermaster o WHERE o.sgstAmount = :sgstAmount"),
    @NamedQuery(name = "Ordermaster.findByGrandAmount", query = "SELECT o FROM Ordermaster o WHERE o.grandAmount = :grandAmount"),
    @NamedQuery(name = "Ordermaster.findByCreatedAt", query = "SELECT o FROM Ordermaster o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Ordermaster.findByUpdatedAt", query = "SELECT o FROM Ordermaster o WHERE o.updatedAt = :updatedAt")})
public class Ordermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderId")
    private Integer orderId;
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
    @Column(name = "taxAmount")
    private double taxAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gstAmount")
    private double gstAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sgstAmount")
    private int sgstAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grandAmount")
    private double grandAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<Billmaster> billmasterCollection;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Usermaster userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<Paymentmaster> paymentmasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<Orderdetail> orderdetailCollection;

    public Ordermaster() {
    }

    public Ordermaster(Integer orderId) {
        this.orderId = orderId;
    }

    public Ordermaster(Integer orderId, double totalAmount, double discount, double taxAmount, double gstAmount, int sgstAmount, double grandAmount, Date createdAt) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.taxAmount = taxAmount;
        this.gstAmount = gstAmount;
        this.sgstAmount = sgstAmount;
        this.grandAmount = grandAmount;
        this.createdAt = createdAt;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public int getSgstAmount() {
        return sgstAmount;
    }

    public void setSgstAmount(int sgstAmount) {
        this.sgstAmount = sgstAmount;
    }

    public double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(double grandAmount) {
        this.grandAmount = grandAmount;
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

    public Collection<Billmaster> getBillmasterCollection() {
        return billmasterCollection;
    }

    public void setBillmasterCollection(Collection<Billmaster> billmasterCollection) {
        this.billmasterCollection = billmasterCollection;
    }

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
    }

    public Collection<Paymentmaster> getPaymentmasterCollection() {
        return paymentmasterCollection;
    }

    public void setPaymentmasterCollection(Collection<Paymentmaster> paymentmasterCollection) {
        this.paymentmasterCollection = paymentmasterCollection;
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
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordermaster)) {
            return false;
        }
        Ordermaster other = (Ordermaster) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ordermaster[ orderId=" + orderId + " ]";
    }
    
}
