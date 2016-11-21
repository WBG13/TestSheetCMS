package http.listeners;

import controller.errors.DocumentNotFoundException;
import controller.managers.EmployeeManager;
import model.beans.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/API/Document/Employee")
public class EmployeeAPI {

    EmployeeManager employeeManager = new EmployeeManager();

    @GET
    @Path("/organization/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployees(@PathParam("id") String id, @QueryParam("limit") int limit, @QueryParam("offset") int offset) {
        return employeeManager.GetEmployees(id, limit, offset);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createEmployee(Employee Employee) {
        employeeManager.CreateEmployee(Employee);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployee(Employee Employee) {
        try {
            employeeManager.UpdateEmployee(Employee);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/{id2}")
    public void deleteEmployee(@PathParam("id2") String id2) {
        try {
            employeeManager.DeleteEmployee(id2);
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
    }
}
