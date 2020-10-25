/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject.shopfront.service;

import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import myproject.shopfront.model.Product;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import project.MyCredentials;
import token.GenerateToken;

/**
 *
 * @author root
 */
@RegisterRestClient(configKey = "productClient", baseUri =  "http://localhost:8086/ProductCatalogue/rest")
@ApplicationScoped
 //@Named
@Path("/product")
public interface ProductClient {
   // @Inject  MyCredentials credential;
    
    
    @GET
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAvailableProducts();
    
    default String generateJWTToken() {
        
        Config config = ConfigProvider.getConfig();
         String token ="Bearer "+ GenerateToken.generateJWT();
       System.out.println("Product Token = "+token);
        return token;
    }
}
