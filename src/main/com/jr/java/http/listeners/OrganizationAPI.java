package http.listeners;

import controller.errors.DocumentNotFoundException;
import controller.managers.OrganizationManager;
import model.beans.Organization;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/API/Document/Organization")
public class OrganizationAPI {

    @Inject
    OrganizationManager organizationManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Organization> getOrganizations(@QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return organizationManager.GetOrganizations(limit, offset);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createOrganization(Organization Organization) {
        organizationManager.CreateOrganization(Organization);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOrganization(Organization Organization) {
        try {
            organizationManager.UpdateOrganization(Organization);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/{id2}")
    public void deleteOrganization(@PathParam("id2") String id2) {
        try {
            organizationManager.DeleteOrganization(id2);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
    }
}
