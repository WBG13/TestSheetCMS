package http.listeners;

import controller.dAO.EmployeeDao;
import model.beans.Employee;

import javax.ws.rs.core.*;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import java.util.List;

@Path("test/")   // make this class processes this url. empno is a variable that represents employee number.
public class EmployeeResource {
//    public EmployeeResource() {
//    }


//    @Path("/employee/{empno}")
//    @GET   // this method process GET request from client
//    @Produces("application/json")   // sends JSON
//    public String getJson( @PathParam("empno") int empno) {  // empno represents the empno sent from client
//        System.out.println("This is pre recorded message, we hope you can create your project in time.");
//        switch(empno) {
//            case 1 :
//                return "{'name':'George Koch', 'age':58}";
//            case 2:
//                return "{'name':'Peter Norton', 'age':50}";
//            default:
//                return "{'name':'unknown', 'age':-1}";
//        } // end of switch
//    } // end of getJson()
//
//    public javax.ws.rs.core.Response output(){
//        System.out.println("Harro!");
//        return javax.ws.rs.core.Response.status(200)
//                .entity("Catched request: ")
//                .build();
//
//    }

    @Path ("path/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMemberList() {
        System.out.println("smth str");
        EmployeeDao ed = new EmployeeDao();
        List<Employee> memberList = ed.getAllEmployee();
        //members.addAll(memberList);
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(memberList)
                .build();
    }
}
