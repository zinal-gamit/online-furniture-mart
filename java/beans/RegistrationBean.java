/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.UserbeanLocal;
import entity.Usermaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Zinal
 */
@Named(value = "registrationBean")
@RequestScoped
public class RegistrationBean {
 @EJB
    private UserbeanLocal usb;
    
    @Resource
    private UserTransaction utx;

    @PersistenceContext(unitName = "persistence_unit")
    EntityManager em; 
    
    //Adminclient admin = new Adminclient();
    Response res;
    Usermaster obj = new Usermaster();
    
   
    String userName, password, email, firstName, lastName,  address, city,  state, country;
    Integer MobileNo,pincode,groupId;

    Collection<Usermaster> Register;
    GenericType<Collection<Usermaster>> gUsers;
    
    public RegistrationBean() {
        
        Register = new ArrayList<>();
        gUsers = new GenericType<Collection<Usermaster>>(){
        };
    }

    public UserbeanLocal getUsb() {
        return usb;
    }

    public void setUsb(UserbeanLocal usb) {
        this.usb = usb;
    }

    public UserTransaction getUtx() {
        return utx;
    }

    public void setUtx(UserTransaction utx) {
        this.utx = utx;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public Usermaster getObj() {
        return obj;
    }

    public void setObj(Usermaster obj) {
        this.obj = obj;
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

    public Integer getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(Integer MobileNo) {
        this.MobileNo = MobileNo;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Collection<Usermaster> getRegister() {
        return Register;
    }

    public void setRegister(Collection<Usermaster> Register) {
        this.Register = Register;
    }

    public GenericType<Collection<Usermaster>> getgUsers() {
        return gUsers;
    }

    public void setgUsers(GenericType<Collection<Usermaster>> gUsers) {
        this.gUsers = gUsers;
    }
    
    public String Register(){
        this.usb.Register(userName, password, email, firstName, lastName, MobileNo, address, city, pincode, state, country);
        return "login.xhtml";
    }

    
}
