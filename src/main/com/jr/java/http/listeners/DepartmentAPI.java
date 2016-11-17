package http.listeners;

import controller.managers.DepartmentManager;
import model.beans.Department;
import model.beans.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/API/Document")
public class DepartmentAPI {

    DepartmentManager departmentManager = new DepartmentManager();

    @GET
    @Path("/organization/{id}/department")
    @Produces(MediaType.APPLICATION_JSON)
    public List< Department > getDepartments( @PathParam("id") String id ) {
        return departmentManager.GetDepartments( id );
    }

    @POST
    @Path("/organization/{id}/department")
    @Produces(MediaType.APPLICATION_JSON)
    public List< Department > createDepartment( @PathParam("id") String id ) {
        return departmentManager.GetDepartments( id );
    }

}