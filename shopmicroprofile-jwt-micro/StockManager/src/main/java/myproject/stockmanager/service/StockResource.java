package myproject.stockmanager.service;

import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import myproject.stockmanager.model.StockService;

@Path("/stock")
public class StockResource {
    @Inject StockService stock;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Integer> getAvailableProductIds() {
        return stock.getAvailablIds();
    }

}
