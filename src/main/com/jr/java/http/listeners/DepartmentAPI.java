package http.listeners;

import controller.errors.DocumentNotFoundException;
import controller.managers.DepartmentManager;
import model.beans.Department;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/API/Document/Department")
public class DepartmentAPI {

    DepartmentManager departmentManager = new DepartmentManager();

    @GET
    @Path("/organization/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getDepartments(@PathParam("id") String id, @QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return departmentManager.GetDepartments(id, limit, offset);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDepartment(Department department) {
        departmentManager.CreateDepartment(department);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDepartment(Department department) {
        try {
            departmentManager.UpdateDepartment(department);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/{id2}")
    public void deleteDepartment(@PathParam("id2") String id2) {
        try {
            departmentManager.DeleteDepartment(id2);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
    }
}