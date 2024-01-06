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
@Table(name = "wishlist")
@NamedQueries({
    @NamedQuery(name = "Wishlist.findAll", query = "SELECT w FROM Wishlist w"),
    @NamedQuery(name = "Wishlist.findByWishlistId", query = "SELECT w FROM Wishlist w WHERE w.wishlistId = :wishlistId"),
    @NamedQuery(name = "Wishlist.findBySize", query = "SELECT w FROM Wishlist w WHERE w.size = :size"),
    @NamedQuery(name = "Wishlist.findByGrandAmount", query = "SELECT w FROM Wishlist w WHERE w.grandAmount = :grandAmount"),
    @NamedQuery(name = "Wishlist.findByCreatedAt", query = "SELECT w FROM Wishlist w WHERE w.createdAt = :createdAt"),
    @NamedQuery(name = "Wishlist.findByUpdatedAt", query = "SELECT w FROM Wishlist w WHERE w.updatedAt = :updatedAt")})
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wishlistId")
    private Integer wishlistId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "size")
    private String size;
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
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Usermaster userId;
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    @ManyToOne(optional = false)
    private Productmaster productId;

    public Wishlist() {
    }

    public Wishlist(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Wishlist(Integer wishlistId, String size, double grandAmount, Date createdAt) {
        this.wishlistId = wishlistId;
        this.size = size;
        this.grandAmount = grandAmount;
        this.createdAt = createdAt;
    }

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public Usermaster getUserId() {
        return userId;
    }

    public void setUserId(Usermaster userId) {
        this.userId = userId;
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
        hash += (wishlistId != null ? wishlistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.wishlistId == null && other.wishlistId != null) || (this.wishlistId != null && !this.wishlistId.equals(other.wishlistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Wishlist[ wishlistId=" + wishlistId + " ]";
    }
    
}
