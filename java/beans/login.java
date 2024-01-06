///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
// */
//package beans;
//
//import ejb.SessionStorageBean;
//import ejb.UserbeanLocal;
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.Set;
//import javax.ejb.EJB;
//import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.security.enterprise.AuthenticationStatus;
//import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
//import javax.security.enterprise.SecurityContext;
//import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
//import javax.security.enterprise.credential.Credential;
//import javax.security.enterprise.credential.Password;
//import javax.security.enterprise.credential.UsernamePasswordCredential;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author Vidhi
// */
//@Named(value = "login")
//@RequestScoped
//public class login {
//    String userName;
//    String password;
//    boolean remember;
//    String errormessage;
//    private AuthenticationStatus status;
//    private Set<String> groups;
//    @Inject private SecurityContext securityContext;
//    @Inject private SessionStorageBean ssb;
//    //Register
//    String username;
//    String r_password;
//    String email;
//    String firstName;
//    String lastName;
//    String MobileNo;
//    String address;
//    String city;
//    String pincode;
//    String state;
//    String country;
//
//    @EJB UserbeanLocal ubl;
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isRemember() {
//        return remember;
//    }
//
//    public void setRemember(boolean remember) {
//        this.remember = remember;
//    }
//
//    public String getErrormessage() {
//        return errormessage;
//    }
//
//    public void setErrormessage(String errormessage) {
//        this.errormessage = errormessage;
//    }
//
//    public AuthenticationStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(AuthenticationStatus status) {
//        this.status = status;
//    }
//
//    public Set<String> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(Set<String> groups) {
//        this.groups = groups;
//    }
//
//    public SecurityContext getSecurityContext() {
//        return securityContext;
//    }
//
//    public void setSecurityContext(SecurityContext securityContext) {
//        this.securityContext = securityContext;
//    }
//
//    public SessionStorageBean getSsb() {
//        return ssb;
//    }
//
//    public void setSsb(SessionStorageBean ssb) {
//        this.ssb = ssb;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    
//
//    public String getR_password() {
//        return r_password;
//    }
//
//    public void setR_password(String r_password) {
//        this.r_password = r_password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMobileNo() {
//        return MobileNo;
//    }
//
//    public void setMobileNo(String MobileNo) {
//        this.MobileNo = MobileNo;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getPincode() {
//        return pincode;
//    }
//
//    public void setPincode(String pincode) {
//        this.pincode = pincode;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public UserbeanLocal getUbl() {
//        return ubl;
//    }
//
//    public void setUbl(UserbeanLocal ubl) {
//        this.ubl = ubl;
//    }
//    
//    
//
//    /**
//     * Creates a new instance of login
//     */
//    public login() {
//        remember = true;
//    }
//    public String loginMethod(){
//        FacesContext context = FacesContext.getCurrentInstance();
//    try{
//        
//          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//      
//        request.getSession().setAttribute("logged-group", ""); 
//        
//        Credential credential = new UsernamePasswordCredential(userName, new Password(password));
//        AuthenticationStatus status= securityContext.authenticate(request, response, withParams().credential(credential));
//                                           
//     
//       if (status.equals(SEND_CONTINUE)) {
//            // Authentication mechanism has send a redirect, should not
//            // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
//            context.responseComplete();
//       } 
//       
// 
//         System.out.println("In bean");
//         ssb.setUserName(userName);
//         System.out.println("User name in login:"+ssb.getUserName());
//         if(groups.contains("Admin"))
//           {
//               System.out.println("In admin");
//               request.getSession().setAttribute("logged-group", "admin");
//              return "category.xhtml";
//           }
//        //   else if(securityContext.isCallerInRole("Supervisor"))
//       else if(groups.contains("User"))
//           {
//               System.out.println("In user");
//               request.getSession().setAttribute("logged-group", "user");
//               return "/user/index.jsf?faces-redirect=true";
//           }
//         }
//        catch (Exception e)
//        {
//           // errorMessage = "Out- Either user or login is wrong !!!";
//           e.printStackTrace();
//        }
//    return "/index.xhtml";
//    }
//    public String registerMethod()
//    {
//       Integer mn = Integer.parseInt(MobileNo);
//       Integer pc = Integer.parseInt(pincode);
//        ubl.Register(userName, password, email, firstName, lastName, mn, address, city, pc, state, country);
//        return "index.jsf";
//    }
//
//    
//    
//    
//}
