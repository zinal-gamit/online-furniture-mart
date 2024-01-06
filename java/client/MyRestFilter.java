/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package client;

import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import jwtrest.TokenProvider;
import record.keeprecord;


/**
 * This RequestFilter performs a form based authentication. The filter can be
 * used with a javax.ws.rs.client.Client.
 * 
 * Author : Kamlendu Pandey
 */
//@Secured

//@WebFilter(filterName = "AuthenticationFilter", urlPatterns = { "/webresources/*" })
@Provider
@PreMatching
public class MyRestFilter implements ClientRequestFilter {
    public static String mytoken;
   // @Inject KeepRecord keepRecord;
    
    public MyRestFilter() {      
       // mytoken = token;
     }
 
    @Override
     public void filter(ClientRequestContext requestContext) throws IOException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
             System.out.println(" In form Auth Client Filter "+ mytoken);
      
       
           requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION,"Bearer "+ keeprecord.getToken());
      
     // System.out.println(" After cookie header Auth Client Filter "+ mytoken);
   
    }

    
}