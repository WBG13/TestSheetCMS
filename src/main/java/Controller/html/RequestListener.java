package Controller.html;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by TH-221 on 08.11.2016.
 */
@Path("DocumentManagement/user")
public class RequestListener {

    @POST
    @Path("/check")
    public Response addUser(
            @FormParam("name") String name,
            @FormParam("patronymic") String patronymic,
            @FormParam("position") String position,
            @FormParam("surname") String surname) {

        return Response.status(200)
                .entity("Catched request: \n Name : " + name + ", Surname : " + surname
                        + ", Patronymic : " + patronymic + ", Position : " + position)
                .build();

    }
}
