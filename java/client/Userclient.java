/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:useRest [useRest]<br>
 * USAGE:
 * <pre>
 *        Userclient client = new Userclient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Zinal
 */
public class Userclient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FurnitureStore/resources";

    public Userclient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("useRest");
    }

    public <T> T getProById(Class<T> responseType, String ProductId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProById/{0}", new Object[]{ProductId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addWish(Object requestEntity, String productId, String userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addWish/{0}/{1}", new Object[]{productId, userId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAll");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertFeed(Object requestEntity, String userId, String productId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertFeed/{0}/{1}", new Object[]{userId, productId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getFeedById(Class<T> responseType, String feedbackId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getFeedById/{0}", new Object[]{feedbackId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void delOrder(String orderDetailId, String orderId, String productId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("delOrderMaster/{0}/{1}/{2}", new Object[]{orderDetailId, orderId, productId})).request().delete();
    }

    public void InsertPay(Object requestEntity, String orderId, String userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("InsertPay/{0}/{1}", new Object[]{orderId, userId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getPayByUid(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getByUid/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCartByUid(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getWishByUid/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateWish(Object requestEntity, String wishlistId, String productId, String userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateWish{0}/{1}/{2}", new Object[]{wishlistId, productId, userId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllCart(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllWish");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void inOrderMaster(Object requestEntity, String userId, String ProductId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("inOrderMaster/{0}/{1}", new Object[]{userId, ProductId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getOById(Class<T> responseType, String orderId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getOById/{0}", new Object[]{orderId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPayById(Class<T> responseType, String paymentId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getById/{0}", new Object[]{paymentId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void Register(Object requestEntity, String userName, String password, String email, String firstName, String lastName, String MobileNo, String address, String city, String pincode, String state, String country) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("Register/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{userName, password, email, firstName, lastName, MobileNo, address, city, pincode, state, country})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deletecat(String wishlistId, String productId, String userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteWish/{0}/{1}/{2}", new Object[]{wishlistId, productId, userId})).request().delete();
    }

    public <T> T getBillById(Class<T> responseType, String billId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getBillById/{0}", new Object[]{billId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addOrder(Object requestEntity, String orderId, String productId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addOrder/{0}/{1}", new Object[]{orderId, productId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getByUser(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getOByUid/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllProduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllProduct");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void delOrderMaster(String orderId, String userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("delOrderMaster/{0}/{1}", new Object[]{orderId, userId})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
