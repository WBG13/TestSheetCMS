package http.listeners;

import controller.errors.DocumentNotFoundException;
import controller.errors.DocumentStatusTransitionError;
import controller.errors.DocumentValidationError;
import controller.managers.OrderManager;
import model.beans.Order;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/API/Document/Order")
public class OrderAPI {

    @Inject
    OrderManager orderManager;

    @GET
    @Path("/account/{id}/assignedOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAssignedOrders(@PathParam("id") String id, @QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return orderManager.GetOrdersFor(id, limit, offset);
    }

    @GET
    @Path("/account/{id}/submittedOrders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getSubmittedOrders(@PathParam("id") String id, @QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return orderManager.GetOrdersBy(id, limit, offset);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void CreateOrder(Order order) {
        try {
            orderManager.CreateOrder(order);
        } catch (DocumentValidationError documentValidationError) {
            documentValidationError.printStackTrace();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrder(Order order) {
        try {
            orderManager.UpdateOrder(order);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentStatusTransitionError documentStatusTransitionError) {
            documentStatusTransitionError.printStackTrace();
        } catch (DocumentValidationError documentValidationError) {
            documentValidationError.printStackTrace();
        }
    }

    @DELETE
    @Path("/{id2}")
    public void deleteEmployee(@PathParam("id2") String id2) {
        try {
            orderManager.DeleteOrder(id2);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
    }
}
