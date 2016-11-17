package http.listeners;
import controller.dAO.EmployeeDao;
import model.beans.Employee;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by TH-221 on 14.11.2016.
 */
// The Java class will be hosted at the URI path "/helloworld"
//@Path("Document/")
//public class EmployeeRequestListener {
//    // The Java method will process HTTP GET requests
// //   @GET
//    @Path("/employee")
////    public Response addUser(
//////            @FormParam("name") String name,
//////            @FormParam("patronymic") String patronymic,
//////            @FormParam("position") String position,
//////            @FormParam("surname") String surname) {
////    {
////        return Response.status(200)
////                .entity("Catched request: \n Name : " + name + ", Surname : " + surname
////                        + ", Patronymic : " + patronymic + ", Position : " + position)
////                .build();
////
////    }
//
//
////    @GET
////    // The Java method will produce content identified by the MIME Media type "text/plain"
//    //@Produces("text/plain")
//   // @Produces(MediaType.APPLICATION_JSON)
////    @Produces("application/json")
//  //  @Produces("application/array")
//    public Response getClichedMessage() {
//        System.out.println();
////        Logger logger = LoggerFactory.getLogger(JSONRootElementProvider.App.class);
//        System.out.println("Into the eml");
//        EmployeeDao employeeDao = new EmployeeDao();
//        List outputFromDatabase = employeeDao.getAllEmployee();
////        logger.info(String.valueOf(outputFromDatabase));
//
//        //   response.addHeader("Access-Control-Allow-Origin", "*");
//
//        return Response.ok(String.valueOf(outputFromDatabase), MediaType.APPLICATION_JSON).build();
////        return Response.status(200)
////                // .entity("Hello world").header("Access-Control-Allow-Origin", "*")
//////                .entity(outputFromDatabase).header("Content-Type: application/json; charset=utf8", "*")
////                .entity(outputFromDatabase).header("Content-Type: application/json; charset=utf8", "*")
////                .build();
//
//    }
//}
//


@Path("/Document")
public class EmployeeRequestListener {

    EmployeeDao dao = new EmployeeDao();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Employee> findAll() {
        return dao.getAllEmployee();
    }

//    public Response getEmployee(){
//
//        List<Employee>matched;
//        GenericEntity<List<Employee>> entity;
//
//        matched = new EmployeeDao().getAllEmployee();
//        entity  = new GenericEntity<List<Employee>>(matched) { };
//
//        return Response.ok(entity).build();
//    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employee findById(@PathParam("id") String id) {
        return dao.getEmployeeById(Integer.parseInt(id));
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean create(Employee wine) {
        return dao.addEmployee(wine);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean update(Employee wine) {
        return dao.updateEmployee(wine);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void remove(@PathParam("id") int id) {
        dao.deleteEmployee(id);
    }
}