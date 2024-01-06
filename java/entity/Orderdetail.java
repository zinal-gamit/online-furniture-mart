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

/**
 *
 * @author Vidhi
 */
@Entity
@Table(name = "orderdetail")
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o"),
    @NamedQuery(name = "Orderdetail.findByOrderDetailId", query = "SELECT o FROM Orderdetail o WHERE o.orderDetailId = :orderDetailId"),
    @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderdetail.findByGrandAmount", query = "SELECT o FROM Orderdetail o WHERE o.grandAmount = :grandAmount"),
    @NamedQuery(name = "Orderdetail.findByCreatedAt", query = "SELECT o FROM Orderdetail o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Orderdetail.findByUpdatedAt", query = "SELECT o FROM Orderdetail o WHERE o.updatedAt = :updatedAt")})
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderDetailId")
    private Integer orderDetailId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
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
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    @ManyToOne(optional = false)
    private Productmaster productId;

    public Orderdetail() {
    }

    public Orderdetail(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Orderdetail(Integer orderDetailId, int quantity, double grandAmount, Date createdAt) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
        this.grandAmount = grandAmount;
        this.createdAt = createdAt;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Productmaster getProductId() {
        return productId;
    }

    public void setProductId(Productmaster productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailId != null ? orderDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderDetailId == null && other.orderDetailId != null) || (this.orderDetailId != null && !this.orderDetailId.equals(other.orderDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderdetail[ orderDetailId=" + orderDetailId + " ]";
    }
    
}
