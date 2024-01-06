/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "paymentmaster")
@NamedQueries({
    @NamedQuery(name = "Paymentmaster.findAll", query = "SELECT p FROM Paymentmaster p"),
    @NamedQuery(name = "Paymentmaster.findByPaymentId", query = "SELECT p FROM Paymentmaster p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "Paymentmaster.findByPaymentMode", query = "SELECT p FROM Paymentmaster p WHERE p.paymentMode = :paymentMode"),
    @NamedQuery(name = "Paymentmaster.findByUpiId", query = "SELECT p FROM Paymentmaster p WHERE p.upiId = :upiId"),
    @NamedQuery(name = "Paymentmaster.findByGrandAmount", query = "SELECT p FROM Paymentmaster p WHERE p.grandAmount = :grandAmount"),
    @NamedQuery(name = "Paymentmaster.findByCreatedAt", query = "SELECT p FROM Paymentmaster p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Paymentmaster.findByUpdatedAt", query = "SELECT p FROM Paymentmaster p WHERE p.updatedAt = :updatedAt")})
public class Paymentmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentId")
    private Integer paymentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "paymentMode")
    private String paymentMode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "upiId")
    private String upiId;
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
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    @ManyToOne(optional = false)
    private Ordermaster orderId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Usermaster userId;

    public Paymentmaster() {
    }

    public Paymentmaster(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Paymentmaster(Integer paymentId, String paymentMode, String upiId, double grandAmount, Date createdAt) {
        this.paymentId = paymentId;
        this.paymentMode = paymentMode;
        this.upiId = upiId;
        this.grandAmount = grandAmount;
        this.createdAt = createdAt;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
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

    public Ordermaster getOrderId() {
        return orderId;
    }

    public void setOrderId(Ordermaster orderId) {
        this.orderId = orderId;
    }

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentmaster)) {
            return false;
        }
        Paymentmaster other = (Paymentmaster) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paymentmaster[ paymentId=" + paymentId + " ]";
    }
    
}
