package Controller.html;

import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;

import java.io.*;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by TH-221 on 05.11.2016.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/DocumentManagement")
public class StartPage {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces({MediaType.TEXT_HTML})

    public InputStream viewHome() {
        return new FileHtmlPageProvider().GetHtmlStream(HtmlPageNames.startPage);
    }
}
