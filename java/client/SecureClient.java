/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Zinal
 */
public class SecureClient {
     private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/jwtTryJsf/resources";

    public SecureClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new MyRestFilter());
        webTarget = client.target(BASE_URI).path("secure");
    }

    public String sayHello() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void close() {
        client.close();
    }
    
    
}
