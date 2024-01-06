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
@Table(name = "usermaster")
@NamedQueries({
    @NamedQuery(name = "Usermaster.findAll", query = "SELECT u FROM Usermaster u"),
    @NamedQuery(name = "Usermaster.findByUserId", query = "SELECT u FROM Usermaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usermaster.findByUserName", query = "SELECT u FROM Usermaster u WHERE u.userName = :userName"),
    @NamedQuery(name = "Usermaster.findByPassword", query = "SELECT u FROM Usermaster u WHERE u.password = :password"),
    @NamedQuery(name = "Usermaster.findByEmail", query = "SELECT u FROM Usermaster u WHERE u.email = :email"),
    @NamedQuery(name = "Usermaster.findByFirstName", query = "SELECT u FROM Usermaster u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Usermaster.findByLastName", query = "SELECT u FROM Usermaster u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Usermaster.findByMobileNo", query = "SELECT u FROM Usermaster u WHERE u.mobileNo = :mobileNo"),
    @NamedQuery(name = "Usermaster.findByAddress", query = "SELECT u FROM Usermaster u WHERE u.address = :address"),
    @NamedQuery(name = "Usermaster.findByCity", query = "SELECT u FROM Usermaster u WHERE u.city = :city"),
    @NamedQuery(name = "Usermaster.findByPincode", query = "SELECT u FROM Usermaster u WHERE u.pincode = :pincode"),
    @NamedQuery(name = "Usermaster.findByState", query = "SELECT u FROM Usermaster u WHERE u.state = :state"),
    @NamedQuery(name = "Usermaster.findByCountry", query = "SELECT u FROM Usermaster u WHERE u.country = :country"),
    @NamedQuery(name = "Usermaster.findByCreatedAt", query = "SELECT u FROM Usermaster u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "Usermaster.findByUpdatedAt", query = "SELECT u FROM Usermaster u WHERE u.updatedAt = :updatedAt")})
public class Usermaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MobileNo")
    private int mobileNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pincode")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Feedback> feedbackCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Billmaster> billmasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Ordermaster> ordermasterCollection;
    @JoinColumn(name = "groupId", referencedColumnName = "groupId")
    @ManyToOne(optional = false)
    private Groupmaster groupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Wishlist> wishlistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Paymentmaster> paymentmasterCollection;

    public Usermaster() {
    }

    public Usermaster(Integer userId) {
        this.userId = userId;
    }

    public Usermaster(Integer userId, String userName, String password, String email, String firstName, String lastName, int mobileNo, String address, String city, int pincode, String state, String country, Date createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.address = address;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
        this.createdAt = createdAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Collection<Billmaster> getBillmasterCollection() {
        return billmasterCollection;
    }

    public void setBillmasterCollection(Collection<Billmaster> billmasterCollection) {
        this.billmasterCollection = billmasterCollection;
    }

    public Collection<Ordermaster> getOrdermasterCollection() {
        return ordermasterCollection;
    }

    public void setOrdermasterCollection(Collection<Ordermaster> ordermasterCollection) {
        this.ordermasterCollection = ordermasterCollection;
    }

    public Groupmaster getGroupId() {
        return groupId;
    }

    public void setGroupId(Groupmaster groupId) {
        this.groupId = groupId;
    }

    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

    public Collection<Paymentmaster> getPaymentmasterCollection() {
        return paymentmasterCollection;
    }

    public void setPaymentmasterCollection(Collection<Paymentmaster> paymentmasterCollection) {
        this.paymentmasterCollection = paymentmasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usermaster)) {
            return false;
        }
        Usermaster other = (Usermaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usermaster[ userId=" + userId + " ]";
    }
    
}
