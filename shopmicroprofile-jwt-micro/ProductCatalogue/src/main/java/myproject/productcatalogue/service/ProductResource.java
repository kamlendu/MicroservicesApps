package myproject.productcatalogue.service;

import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import myproject.productcatalogue.entity.Product;
import myproject.productcatalogue.model.ProductService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/product")
public class ProductResource {
    
@Inject ProductService product;
    
@Inject @RestClient StockClient stockclient;
@Inject JsonWebToken token;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAvailableProducts() {
        System.out.println("Recieved Raw Token in Product "+ token.getRawToken());
        RawToken.setRtoken(token.getRawToken());
        System.out.println("Entered in product Resource..");
        Collection<Integer> allids = stockclient.getAvailableProductIds();
        return product.getAvailableProducts(allids);
    }

}
