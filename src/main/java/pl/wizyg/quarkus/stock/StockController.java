package pl.wizyg.quarkus.stock;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/stocks")
public class StockController {

    interface Routes {
        String SINGLE_STOCK ="/{stockId}";
    }

    @Inject
    StockService stockService;

    @GET
    @Produces("application/json")
    public Response getAllStocks() {
        return Response.ok(stockService.getAllStocks()).build();
    }

    @GET
    @Path(Routes.SINGLE_STOCK)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response getStockById(@PathParam("stockId") Long stockId) {
        return Response.ok(stockService.getStock(stockId)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createStock(StockForm form) {
        return Response.created(URI.create("stocks")).build();
    }



}
