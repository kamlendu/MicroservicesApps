/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author root
 */
@RegisterRestClient(baseUri = "http://localhost:8080/SampleMicroProfileApp/rest/example")
public interface ExampleClient {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String get();
    
}
