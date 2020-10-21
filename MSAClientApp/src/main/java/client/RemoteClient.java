/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author root
 */
//@RegisterRestClient(baseUri = "http://localhost:8080/SampleMicroProfileApp/rest/example")
@RegisterRestClient(configKey = "myclient")
//@ClientHeaderParam(name = "X-Application-Name", value = "Purchase-MGT-APP")
@ClientHeaderParam(name = "authorization", value = "{generateJWTToken}")

public interface RemoteClient {
     @GET
    @Produces(MediaType.TEXT_PLAIN)
    String get();
    
    default String generateJWTToken()
    {
        
        Config config = ConfigProvider.getConfig();
       // String token = "Bearer "+ config.getValue("jwt-string", String.class);
       String token = "Bearer "+ GenerateToken.generateJWT();
        System.out.println("token = "+ token);
        return token;
    }
    
    
}
