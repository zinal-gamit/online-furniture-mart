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
@Table(name = "billmaster")
@NamedQueries({
    @NamedQuery(name = "Billmaster.findAll", query = "SELECT b FROM Billmaster b"),
    @NamedQuery(name = "Billmaster.findByBillId", query = "SELECT b FROM Billmaster b WHERE b.billId = :billId"),
    @NamedQuery(name = "Billmaster.findByFirstName", query = "SELECT b FROM Billmaster b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "Billmaster.findByDescription", query = "SELECT b FROM Billmaster b WHERE b.description = :description"),
    @NamedQuery(name = "Billmaster.findByGrandAmount", query = "SELECT b FROM Billmaster b WHERE b.grandAmount = :grandAmount"),
    @NamedQuery(name = "Billmaster.findByPaymentType", query = "SELECT b FROM Billmaster b WHERE b.paymentType = :paymentType"),
    @NamedQuery(name = "Billmaster.findByCreatedAt", query = "SELECT b FROM Billmaster b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Billmaster.findByUpdatedAt", query = "SELECT b FROM Billmaster b WHERE b.updatedAt = :updatedAt")})
public class Billmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "billId")
    private Integer billId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grandAmount")
    private double grandAmount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "paymentType")
    private String paymentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Usermaster userId;
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    @ManyToOne(optional = false)
    private Ordermaster orderId;

    public Billmaster() {
    }

    public Billmaster(Integer billId) {
        this.billId = billId;
    }

    public Billmaster(Integer billId, String firstName, String description, double grandAmount, String paymentType, Date createdAt) {
        this.billId = billId;
        this.firstName = firstName;
        this.description = description;
        this.grandAmount = grandAmount;
        this.paymentType = paymentType;
        this.createdAt = createdAt;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getGrandAmount() {
        return grandAmount;
    }

    public void setGrandAmount(double grandAmount) {
        this.grandAmount = grandAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
    }

    public Ordermaster getOrderId() {
        return orderId;
    }

    public void setOrderId(Ordermaster orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billId != null ? billId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billmaster)) {
            return false;
        }
        Billmaster other = (Billmaster) object;
        if ((this.billId == null && other.billId != null) || (this.billId != null && !this.billId.equals(other.billId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Billmaster[ billId=" + billId + " ]";
    }
    
}
