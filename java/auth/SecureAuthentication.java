/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package auth;

import beans.Loginbean;
import ejb.UserbeanLocal;
import io.jsonwebtoken.ExpiredJwtException;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jwtrest.JWTCredential;
import jwtrest.TokenProvider;
import static jwtrest.constants.AUTHORIZATION_HEADER;
import static jwtrest.constants.BEARER;
import record.keeprecord;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable {

    @Inject
    IdentityStoreHandler handler;
    CredentialValidationResult result;
    AuthenticationStatus status;
    @Inject
    TokenProvider tokenProvider;
    @Inject
    Loginbean lbean;

    @EJB
    UserbeanLocal ul;
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            if (request.getRequestURI().contains("logout")) {
                request.logout();
                keeprecord.reset();
                response.sendRedirect("login.jsf");
                return ctx.doNothing();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String token = extractToken(ctx);
        try {
            System.out.println("email = " + request.getParameter("email"));
            if (token == null && request.getParameter("email") != null) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println("In Auth");
//                String username = lbean.getUsername();
//                String password = lbean.getPassword();
//                
                Credential credential = new UsernamePasswordCredential(email, new Password(password));
                result = handler.validate(credential);

                if (result.getStatus() == Status.VALID) {
                    keeprecord.setErrorStatus("");
                    AuthenticationStatus status = createToken(result, ctx);

                    status = ctx.notifyContainerAboutLogin(result);

                 //   KeepRecord.setUsername(username);
                 //   KeepRecord.setPassword(password);
                    keeprecord.setPrincipal(result.getCallerPrincipal());
                    keeprecord.setRoles(result.getCallerGroups());
                    keeprecord.setCredential(credential);

                    
            
                    if (result.getCallerGroups().contains("2")) {
                        HttpSession session = request.getSession();
                       session.setAttribute("Admin",email);
                        response.sendRedirect("Admin/admin.jsf");
//                        request.getRequestDispatcher("admin/Admin.jsf").forward(request, response);
                    }
                    if (result.getCallerGroups().contains("1")) {
                        Integer userId = ul.getIdByEmail(email);
                        HttpSession session = request.getSession();
                       session.setAttribute("user",userId);
                       response.sendRedirect("user/home.jsf");
//                        request.getRequestDispatcher("user/User.jsf").forward(request, response);
                    }
                    
                    return status;

                } else {
                    keeprecord.setErrorStatus("Either Username or Password is wrong !");
                    response.sendRedirect("login.jsf");

                    //lbean.setStatus(AuthenticationStatus.SEND_FAILURE);
                    return ctx.doNothing();
                    // request.getServletContext().getRequestDispatcher("/Login.jsf").forward(request, response);
                }
            }

            if (keeprecord.getToken() != null) {
              //  Credential credential1 = new UsernamePasswordCredential(KeepRecord.getUsername(), new Password(KeepRecord.getPassword()));
//                result = handler.validate(KeepRecord.getCredential());
//                AuthenticationStatus status = createToken(result, ctx);
//                
//                if(request.getRequestURI().contains("admin") && result.getCallerGroups().contains("Supervisor"))
//                {
//                    ctx.responseUnauthorized();
//                }
//               else if(request.getRequestURI().contains("user") && result.getCallerGroups().contains("Admin"))
//               {
//                  ctx.responseUnauthorized();
//               }
                
                ctx.notifyContainerAboutLogin(keeprecord.getPrincipal(), keeprecord.getRoles());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (token != null) {
            // validation of the jwt credential

            return validateToken(token, ctx);
        } else if (ctx.isProtected()) {
            // A protected resource is a resource for which a constraint has been defined.
            // if there are no credentials and the resource is protected, we response with unauthorized status
            return ctx.responseUnauthorized();
        }
        return ctx.doNothing();
    }

    private AuthenticationStatus validateToken(String token, HttpMessageContext context) {
        try {
            if (tokenProvider.validateToken(token)) {
                JWTCredential credential = tokenProvider.getCredential(token);
                // System.out.println("JWTAuthenticationMechanism-Token Validated");
                return context.notifyContainerAboutLogin(credential.getPrincipal(), credential.getAuthorities());

            }
            // if token invalid, response with unauthorized status
            return context.responseUnauthorized();
        } catch (ExpiredJwtException eje) {
            //LOGGER.log(Level.INFO, "Security exception for user {0} - {1}", new String[]{eje.getClaims().getSubject(), eje.getMessage()});
            return context.responseUnauthorized();
        }
    }

    /**
     * Create the JWT using CredentialValidationResult received from
     * IdentityStoreHandler
     *
     * @param result the result from validation of UsernamePasswordCredential
     * @param context
     * @return the AuthenticationStatus to notify the container
     */
    private AuthenticationStatus createToken(CredentialValidationResult result, HttpMessageContext context) {
       // if (!isRememberMe(context)) {
            // if (true) {
            String jwt = tokenProvider.createToken(result.getCallerPrincipal().getName(), result.getCallerGroups(), false);
            //context.getRequest().getSession().setAttribute("token", jwt);
            keeprecord.setToken(jwt);
            context.getResponse().addHeader(AUTHORIZATION_HEADER, BEARER + jwt);
            System.out.println("Token Value" + jwt);

        //}
        System.out.println("JWTAuthenticationMechanism - Token Created");

        return context.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
    }

    /**
     * To extract the JWT from Authorization HTTP header
     *
     * @param context
     * @return The JWT access tokens
     */
    private String extractToken(HttpMessageContext context) {
        String authorizationHeader = context.getRequest().getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {
            String token = authorizationHeader.substring(BEARER.length(), authorizationHeader.length());
            keeprecord.setToken(token);
            //  System.out.println("JWTAuthenticationMechanism - Extract Tokens");
            return token;
        }
        return null;
    }

    /**
     * this function invoked using RememberMe.isRememberMeExpression EL
     * expression
     *
     * @param context
     * @return The remember me flag
     */
//    public Boolean isRememberMe(HttpMessageContext context) {
//        return Boolean.valueOf(context.getRequest().getParameter("rememberme"));
//    }
}
