/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package record;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Set;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.identitystore.CredentialValidationResult;

/**
 *
 * @author Zinal
 */
@Named
@SessionScoped
public class keeprecord implements Serializable {

   private static CredentialValidationResult result;
    private static CallerPrincipal principal;
   private static Set<String> roles;
   private static String token;
   private static String userName;
   private static String password;
   private static String errorStatus;
   private static Credential credential;

    public static CredentialValidationResult getResult() {
        return result;
    }

    public static void setResult(CredentialValidationResult result) {
        keeprecord.result = result;
    }

    public static CallerPrincipal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(CallerPrincipal principal) {
        keeprecord.principal = principal;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        keeprecord.roles = roles;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        keeprecord.token = token;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        keeprecord.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        keeprecord.password = password;
    }

    public static String getErrorStatus() {
        return errorStatus;
    }

    public static void setErrorStatus(String errorStatus) {
        keeprecord.errorStatus = errorStatus;
    }

    public static Credential getCredential() {
        return credential;
    }

    public static void setCredential(Credential credential) {
        keeprecord.credential = credential;
    }
   
   
   
    public keeprecord() {
         principal=null;
       token=null;
       userName=null;
       password=null;
       token=null;
       errorStatus="";
    }
    
     public static void reset()
    {
        
       principal=null;
       token=null;
       userName=null;
       password=null;
       token=null;
       errorStatus="";
    }
    
}
